package com.gmail.cacho.slreport.jasper;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.Fecha;
import com.gmail.cacho.slbase.logging.L;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinServlet;
import net.sf.jasperreports.engine.JRException;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.EntityManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.util.Map;

/**
 * ref: https://vaadin.com/docs/v7/framework/articles/JasperReportsOnVaadinSample.html
 *
 * @author Beto
 * @version 20171129
 */
public class ReporteCreator {

    //Base path for report template es en target
    String baseReportsPath = VaadinServlet.getCurrent().getServletContext().getRealPath(C.SYS_REP_DIR_BASE);

    public ReporteCreator() {
    }

    public StreamResource streamResourceReport(String reportTemplate, Map<String, Object> parameterMap, String reportOutputFilename) {
        parameterMap.put(C.SYS_REP_PARAM_TITULO, C.SYS_REP_TITULO);
        parameterMap.put(C.SYS_REP_PARAM_DIRECCION, C.SYS_REP_DIRECCION);

        L.info(Constantes.MSJ_REP_GENERATING_REPORT);
        StreamResource myResource = createPdfResource(reportTemplate, parameterMap, reportOutputFilename);

        L.info(Constantes.MSJ_REP_GENERATING_REPORT_OK);
        return myResource;
    }

    public StreamResource createPdfResource(final String templatePath, Map<String, Object> parameterMap, String reportFileName) {
        return
                new StreamResource(reportFileName + (Constantes.MSJ_REP_GENERATE_PREOUT_STRING + Fecha.getNowDateAsString() + Constantes.MSJ_REP_GENERATE_POSOUT_PDF), () -> {
                    parameterMap.put(C.SYS_REP_PARAM_TITULO, C.SYS_REP_TITULO);
                    parameterMap.put(C.SYS_REP_PARAM_DIRECCION, C.SYS_REP_DIRECCION);

                    ByteArrayOutputStream pdfBuffer = new ByteArrayOutputStream();
                    ReporteFactory reporteFactory = new ReporteFactory();

                    try {
                        //Generate the report
                        reporteFactory.executeReportPdf(baseReportsPath + templatePath, parameterMap, getConnection(), pdfBuffer);
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                    // Return a stream from the buffer.
                    ByteArrayInputStream aa = new ByteArrayInputStream(pdfBuffer.toByteArray());
                    return aa;
                });
    }

    public StreamResource createXlsResource(final String templatePath, Map<String, Object> parameterMap, String reportFileName) {
        return
                new StreamResource((reportFileName + (Constantes.MSJ_REP_GENERATE_PREOUT_STRING + Fecha.getNowDateAsString() + Constantes.MSJ_REP_GENERATE_POSOUT_XLS)), () -> {

                    ByteArrayOutputStream pdfBuffer = new ByteArrayOutputStream();
                    ReporteFactory reporteFactory = new ReporteFactory();

                    try {
                        //Generate the report
                        reporteFactory.executeReportXls(baseReportsPath + templatePath, parameterMap, getConnection(), pdfBuffer);
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                    // Return a stream from the buffer.
                    return new ByteArrayInputStream(pdfBuffer.toByteArray());
                });
    }

    private Connection getConnection() {
        EntityManager em = CDI.current().select(EntityManager.class).get();
        return  em.unwrap(Connection.class);
    }
}
