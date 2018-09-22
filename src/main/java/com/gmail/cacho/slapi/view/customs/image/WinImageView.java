package com.gmail.cacho.slapi.view.customs.image;


import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class WinImageView extends Dialog {
    private String filename;
    private Button cancelar;

    public WinImageView(String caption, String filename) {
        super();
        //super(caption);
        this.filename = filename;

        armarVentana();
        setShortcuts();
    }

    private void armarVentana() {
        //setStyleName("sciolar-window");
        setWidth("900%");
        setHeight("900%");
        /*
        setDraggable(true);
        setResizable(false);
        setClosable(true);
        setWindowMode(WindowMode.NORMAL);
        setModal(true);
        center();
        */

        final Image imagen = new Image();
        imagen.setSrc(Sistema.getSistema().getImagePath().concat(filename));
                ////setSource(new FileResource(new File(Sistema.getSistema().getImagePath().concat(filename))));
        imagen.setWidth("850%");
        imagen.setHeight("700%");
        cancelar = new Button(C.CRUD_FORM_BTN_CANCELAR, clickEvent -> close());
        cancelar.setWidth("120px");

        HorizontalLayout botonera = new HorizontalLayout();
        botonera.setWidth("100%");
        botonera.setHeight("30px");
        botonera.add(cancelar);
        botonera.setAlignSelf(FlexComponent.Alignment.CENTER,cancelar);

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.add(imagen, botonera);
        layout.setFlexGrow(0,botonera);
        layout.setFlexGrow(1,imagen);

        add(layout);
    }

    private void setShortcuts() {
        //cancelar.setClickShortcut(ShortcutAction.KeyCode.F12);
    }
}
