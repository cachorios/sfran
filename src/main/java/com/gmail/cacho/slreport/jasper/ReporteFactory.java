package com.gmail.cacho.slreport.jasper;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.cacho.slreport.excepciones.ReportErrorException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import java.io.File;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

/**
 * Esta clase hace el trabajo, carga la plantilla, compila, completa y exporta el informe.
 *
 * @author Beto
 * @version 20171129
 */
public class ReporteFactory {
    public ReporteFactory() {
    }

    public JasperPrint createPrint(String templatePath, Map<String, Object> parameterMap, Connection conn) throws JRException {
        return fillReport(compileReport(loadTemplate(setTempDirectory(templatePath))), conn, parameterMap);
    }

    public void executeReportPdf(String templatePath, Map<String, Object> parameterMap, Connection conn, OutputStream outputStream)
            throws JRException {
        exportReportToPdf(createPrint(templatePath, parameterMap, conn), outputStream);
    }

    public void executeReportXls(String templatePath, Map<String, Object> parameterMap, Connection conn, OutputStream outputStream)
            throws JRException {
        exportReportToXls(createPrint(templatePath, parameterMap, conn), outputStream);
    }

    /**
     * Carga la plantilla (definida por templatePath) y devuelva un objeto JasperDesign que represente la plantilla
     *
     * @return JasperDesign
     */
    private JasperDesign loadTemplate(String templatePath) {
        JasperDesign jasperDesign;

        L.info(Constantes.MSJ_REP_INF_INITPARES);
        File templateFile = new File(templatePath);
        L.info(Constantes.SYS_APP_ABS_PATH, templateFile.getAbsolutePath());
        if (templateFile.exists()) {
            try {
                L.info(Constantes.MSJ_REP_INF_LOAD);
                jasperDesign = JRXmlLoader.load(templateFile);
                L.info(Constantes.MSJ_REP_INF_LOADOK, jasperDesign.getName());
            } catch (JRException e) {
                throw new ReportErrorException(Constantes.MSJ_REP_ERR_CANTREADTEMPLATE, e.getMessage());
            }
        } else {
            throw new ReportErrorException(Constantes.MSJ_REP_ERR_CANTLOADTEMPLATE);
        }

        return jasperDesign;
    }

    /**
     * Compila el informe y genera una versión binaria de él
     *
     * @param jasperDesign The report design
     * @return JasperReport
     */
    private JasperReport compileReport(JasperDesign jasperDesign) {
        JasperReport jasperReport;

        try {
            L.info(Constantes.MSJ_REP_INF_COMPILE);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            L.info(Constantes.MSJ_REP_INF_COMPILEOK, jasperReport.getCompilerClass());
        } catch (JRException e) {
            throw new ReportErrorException(Constantes.MSJ_REP_ERR_COMPILETEMPLATE, e.getMessage());
        }

        return jasperReport;
    }

    /**
     * Complete el informe y genera una versión binaria
     *
     * @param jasperReport The Compiled report design
     * @return JasperPrint
     */
    private JasperPrint fillReport(JasperReport jasperReport, Connection conn, Map<String, Object> parameterMap) {
        JasperPrint jasperPrint;

        try {
            L.info(Constantes.MSJ_REP_INF_COMPLETE);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            L.info(Constantes.MSJ_REP_INF_COMPLETEOK, jasperPrint.getName());
        } catch (JRException e) {
            throw new ReportErrorException(Constantes.MSJ_REP_ERR_COMPLETE, e.getMessage());
        }

        return jasperPrint;
    }

    /**
     * Prepare a JRExporter for the filled report (to HTML)
     *
     * @param jasperPrint The jasperPrint
     * @return The HTML text
     */
    private void exportReportToPdf(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
        L.info(Constantes.MSJ_REP_EXPORT_PDF);
        try {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            exporter.exportReport();
        } catch (Exception e) {
            throw new ReportErrorException(Constantes.MSJ_REP_ERR_NOEXPORT, e.getMessage());
        }
    }

    /**
     * Prepare a JRExporter for the filled report (to HTML)
     *
     * @param jasperPrint The jasperPrint
     * @return The HTML text
     */
    private void exportReportToXls(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
        L.info(Constantes.MSJ_REP_EXPORT_XLS);
        try {
            SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
            configuration.setOnePagePerSheet(false);
            configuration.setRemoveEmptySpaceBetweenRows(true);
            configuration.setRemoveEmptySpaceBetweenColumns(true);
            configuration.setWhitePageBackground(false);

            configuration.setDetectCellType(true);
            configuration.setForcePageBreaks(false);
            configuration.setCollapseRowSpan(true);

            configuration.setFontSizeFixEnabled(true);

            configuration.setAutoFitPageHeight(true);
            configuration.setWrapText(true);
            configuration.setFreezeRow(6);
            configuration.setFitHeight(10);
            configuration.setFreezeColumn("A;B");
            configuration.setIgnorePageMargins(true);

            configuration.setMaxRowsPerSheet(65536);
            configuration.setIgnorePageMargins(true);
            configuration.setPrintPageBottomMargin(0);

            configuration.setPrintFooterMargin(0);

            JRXlsExporter exporter = new JRXlsExporter();

            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            exporter.setConfiguration(configuration);
            exporter.exportReport();
        } catch (Exception e) {
            throw new ReportErrorException(Constantes.MSJ_REP_ERR_NOEXPORT, e.getMessage());
        }
    }

    /**
     * Establecer el directorio temporal para la generación de informes
     */
    private String setTempDirectory(String templatePath) {
        L.sistema(Constantes.MSJ_REP_INF_SETBASEPATH);
        File templateFile = new File(templatePath);

        L.sistema(Constantes.MSJ_REP_INF_BASEPATH, templateFile.getParent());
        if (templateFile.exists()) {
            System.setProperty(C.SYS_REP_COMPILE_TMP_PROPERTY, templateFile.getParent());
            return templatePath;
        } else {
            throw new ReportErrorException(Constantes.MSJ_REP_ERR_NOBASEPATH);
        }
    }
}
