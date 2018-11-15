package com.gmail.cacho.slapi.view.componentes;

import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;
import org.vaadin.alejandro.PdfBrowserViewer;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ReportSelector extends Button {
    private  ContextMenu contextMenu;
    public ReportSelector() {

    }

    public ReportSelector(String text) {
        super(text);
    }

    public ReportSelector(String text, Component icon) {
        super(text, icon);
    }






    public ReportSelector add(String label, String repFile, Callable<Map<String, Object>> getParm){
        if(contextMenu == null) {
            contextMenu = new ContextMenu(this);
            contextMenu.setOpenOnClick(true);
        }

        contextMenu.addItem(new ItemMenu(label, VaadinIcon.PRINT),e -> genPdf(repFile, label, getParm) );
        contextMenu.addItem(new ItemMenu(label, VaadinIcon.LINE_BAR_CHART),e -> genXls(repFile, label, getParm) );

        return this;
    }

    private StreamResource genXls(String repFile, String label, Callable<Map<String, Object>> getParm) {
        Map<String, Object> parm =new HashMap<String, Object>();

        try {
            parm = getParm.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        parm.put("IS_IGNORE_PAGINATION", Boolean.TRUE);
        return new ReporteCreator().createXlsResource("/"+repFile, parm, label);
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
        public ItemMenu(String caption, VaadinIcon icon) {
            this.add(icon.create(), new Label(caption));
        }
    }



}
