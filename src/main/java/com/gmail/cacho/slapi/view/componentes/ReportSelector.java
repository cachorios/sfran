package com.gmail.cacho.slapi.view.componentes;

import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;

import com.vaadin.flow.component.page.Page;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ReportSelector extends Button {
    private  ContextMenu contextMenu;
    private  Dialog dialog;
    private Integer tipo;

    public static class Recursos{
        public static final Integer PDF = 1;
        public static final Integer XLS = 2;
    }

    public ReportSelector() {
        this.getElement().setAttribute("theme", "primary");
        this.setClassName("action-btn");
    }

    public ReportSelector(String text) {
        super(text);
        this.getElement().setAttribute("theme", "primary");
        this.setClassName("action-btn");
    }

    public ReportSelector(String text, Component icon) {
        super(text, icon);
        this.getElement().setAttribute("theme", "primary");
        this.setClassName("action-btn");
    }

    private void ini() {
        tipo = 0;
        if(contextMenu == null) {
            contextMenu = new ContextMenu(this);
            contextMenu.setOpenOnClick(true);
        }

        if(dialog == null) {
            dialog = new Dialog();
            dialog.setCloseOnEsc(true);
            dialog.setCloseOnOutsideClick(true);
            dialog.addDialogCloseActionListener(e -> {
                dialog.close();
                dialog.removeAll();
            });
        }
    }

    public ReportSelector add(String label, String repFile, Callable<Map<String, Object>> getParm){
        this.ini();

        Image pdfImage = new Image("frontend/images/pdf.png", "pdf");
        pdfImage.setHeight("20px");
        Image xlsImage = new Image("frontend/images/xls.jpg", "xls");
        xlsImage.setHeight("20px");

        contextMenu.addItem(new ItemMenu(label, pdfImage),e -> genPdf(label, repFile, getParm) );
        contextMenu.addItem(new ItemMenu(label, xlsImage),e -> genXls(label, repFile, getParm) );

        return this;
    }

    public ReportSelector addform(String label, String repFile, Callable<Component> filter) {
        this.ini();

        Image pdfImage = new Image("frontend/images/pdf.png", "pdf");
        pdfImage.setHeight("20px");
        Image xlsImage = new Image("frontend/images/xls.jpg", "xls");
        xlsImage.setHeight("20px");

        contextMenu.addItem(new ItemMenu(label, pdfImage),e -> {
            try {
                tipo = Recursos.PDF;
                filter.call();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        contextMenu.addItem(new ItemMenu(label, xlsImage),e -> {
            try {
                tipo = Recursos.XLS;
                filter.call();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        return this;
    }

    // Genera Xls
    public void genXls( String label, String repFile, Callable<Map<String, Object>> getParm) {
        Map<String, Object> parm =new HashMap<String, Object>();

        try {
            parm = getParm.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        parm.put("IS_IGNORE_PAGINATION", Boolean.TRUE);

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Anchor downloadLink = new Anchor(new ReporteCreator().createXlsResource("/"+repFile, parm, label), "download");
        downloadLink.setId(timeStamp);
        downloadLink.getElement().getStyle().set("display", "none");
        downloadLink.getElement().setAttribute("download", true);

        dialog.removeAll();

        dialog.add(downloadLink );
        dialog.setHeight("0px");
        dialog.setWidth("0px");
        dialog.open();


        Page page = UI.getCurrent().getPage();
        page.executeJavaScript("document.getElementById('"+timeStamp+"').click();");

    }

    //    Genera PDF
    public void genPdf( String label, String repFile, Callable<Map<String, Object>> getParm) {
        Map<String, Object> parm =new HashMap<String, Object>();

        try {
            parm = getParm.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PdfBrowserViewer viewer = new PdfBrowserViewer(
                new ReporteCreator().streamResourceReport("/"+repFile, parm, label)
        );

        viewer.setHeight("600px");
        dialog.removeAll();
        dialog.setHeight("600px");
        dialog.setWidth("800px");
        dialog.add(viewer);
        dialog.open();

    }

    public Map<String, Object> getParametro(){
        return new HashMap<>();
    }

    public Dialog getDialog() {
        return this.dialog;
    }

    public Integer getTipo() {
        return tipo;
    }

    private class ItemMenu extends Div {

        public ItemMenu(String caption, Image image) {
            this.setClassName("menu-item");
            this.getElement().getStyle().set("width", "6rem");
            this.add(image,new Span(" "), new Label(caption));
        }
    }

}
