package com.gmail.cacho.slapi.view.componentes;

import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.server.StreamResource;
import org.vaadin.alejandro.PdfBrowserViewer;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ReportSelector extends Button {
    private  ContextMenu contextMenu;

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


    public ReportSelector add(String label, String repFile, Callable<Map<String, Object>> getParm){
        if(contextMenu == null) {
            contextMenu = new ContextMenu(this);
            contextMenu.setOpenOnClick(true);
        }

        Image pdfImage = new Image("frontend/images/pdf.png", "pdf");
        pdfImage.setHeight("20px");
        Image xlsImage = new Image("frontend/images/xls.jpg", "xls");
        xlsImage.setHeight("20px");

        contextMenu.addItem(new ItemMenu(label, pdfImage),e -> genPdf(repFile, label, getParm) );
        contextMenu.addItem(new ItemMenu(label, xlsImage),e -> genXls(repFile, label, getParm) );

        return this;
    }

    private void genXls(String repFile, String label, Callable<Map<String, Object>> getParm) {
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

        final Dialog dialog = new Dialog();
        dialog.removeAll();

        dialog.add(downloadLink );
        dialog.open();
        dialog.setHeight("0px");
        dialog.setWidth("0px");

        Page page = UI.getCurrent().getPage();
        page.executeJavaScript("document.getElementById('"+timeStamp+"').click();");

    }

    private void genPdf(String repFile, String label, Callable<Map<String, Object>> getParm) {
        Map<String, Object> parm =new HashMap<String, Object>();

        try {
            parm = getParm.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DefaultPDFViewDialog view = new DefaultPDFViewDialog();
        PdfBrowserViewer viewer = new PdfBrowserViewer(
                new ReporteCreator().streamResourceReport("/"+repFile, parm, label)
        );
        viewer.setHeight("100%");
        view.getDialog().add(viewer);
        view.open();




    }


    public Map<String, Object> getParametro(){
        return new HashMap<>();
    }





    private class ItemMenu extends Div {

        public ItemMenu(String caption, Image image) {
            this.setClassName("menu-item");
            this.getElement().getStyle().set("width", "6rem");
            this.add(image,new Span(" "), new Label(caption));
        }
    }



}
