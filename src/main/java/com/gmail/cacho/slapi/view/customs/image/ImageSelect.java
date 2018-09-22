package com.gmail.cacho.slapi.view.customs.image;


import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.shared.Registration;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ImageSelect extends Component implements HasValue {
    private IVisualizable padre;
    private String valor;
    private String titulo;
    private TextField codigo = new TextField();

    @Override
    public Registration addValueChangeListener(ValueChangeListener valueChangeListener) {
        return null;
    }

    @Override
    public void setReadOnly(boolean b) {

    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public void setRequiredIndicatorVisible(boolean b) {

    }

    @Override
    public boolean isRequiredIndicatorVisible() {
        return false;
    }

    private Button ver = new Button();
    private Upload upload = new Upload();
    private NativeButton uploadButton = new NativeButton();
    private boolean conUpload, conVer;
    ////////////private Receiver receiver = new ImageReceiver();

    private final long UPLOAD_LIMIT = 1000000l;

    public ImageSelect(String caption, boolean conUpload, boolean conVer, IVisualizable padre) {
        super();

//        setCaption(caption);
//        setStyleName("small");

        this.conUpload = conUpload;
        this.conVer = conVer;
        this.padre = padre;
        this.titulo = caption;

        initContent();
    }

    public void setEditable(boolean editable) {
        //upload.setEnabled(editable);
    }

    protected Button completarVer(Button ver) {
        ver.setEnabled(true);
        ver.getElement().setProperty("title", C.CRUD_MSG_VER);
        ver.setIcon(VaadinIcon.EYE.create());
        ver.addClickListener(e -> {
            try {
                if (getValue() != null) {
                    ////Sistema.getSistema().getUIPpal().addWindow(new WinImageView(getTitulo(), getValue()));
                } else {
                    Sistema.getSistema()
                           .mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_NOITEM, titulo.toUpperCase());
                }
            } catch (Exception ex) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_CANTSHOW_ITEM, ex.getMessage());
            }
        });
        return ver;
    }

    protected String getCodigo() { return valor; }

    protected String getTitulo() { return C.WIN_TIT_SHOWIMAGE; }

    public IVisualizable getPadre() {
        return padre;
    }


    protected Component initContent() {
        HorizontalLayout layout = new HorizontalLayout();



//        codigo.setStyleName("small");
//        codigo.addStyleName("custom_select_width");
        codigo.setEnabled(false);
        if (conUpload) {
            Div output = new Div();
            MemoryBuffer buffer = new MemoryBuffer();
            upload.setUploadButton(uploadButton);
            Span dropLabel = new Span("Arrestre y descargue aqui!");
            upload.setDropLabel(dropLabel);

            Span dropIcon = new Span("¸¸.•*¨*•♫♪");
            upload.setDropLabelIcon(dropIcon);


            upload.addSucceededListener(event -> {
                Component component = createComponent(event.getMIMEType(),
                        event.getFileName(), buffer.getInputStream());
                showOutput(event.getFileName(), component, output);
            });



//            upload.setStyleName("small");


            upload.addStartedListener(  event -> {
                if (event.getContentLength() > UPLOAD_LIMIT) {
                    Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_TOOBIG_FILE, String.valueOf(UPLOAD_LIMIT));
                    upload.interruptUpload();
                }
            });
            upload.addProgressListener( e -> {
                if (e.getReadBytes() > UPLOAD_LIMIT) {

                    Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_TOOBIG_FILE, String.valueOf(UPLOAD_LIMIT));
                    upload.interruptUpload();
                }
            });

            VerticalLayout grupoCodigo = new VerticalLayout();
            grupoCodigo.setWidth("-1%");
            grupoCodigo.add(codigo);
            if (conVer) { grupoCodigo.add(completarVer(ver)); }
            grupoCodigo.add(upload);
            //grupoCodigo.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
            layout.add(grupoCodigo);
            layout.setFlexGrow(0,grupoCodigo);
        } else {
            layout.add(codigo);
        }

        layout.setWidth("100%");
        layout.setMargin(false);
        layout.setSpacing(false);

        return layout;
    }


    @Override
    public void setValue(Object o) {
        valor = (String) o;
        codigo.setValue(valor);
    }

    @Override
    public String getValue() {
        return valor;
    }

    //////////////////////////////////////////////////////////////////////////
    // Clase Interna que representa el receptor de imagenes
    //////////////////////////////////////////////////////////////////////////


 /*
    class ImageReceiver implements com.vaadin.ui.Upload.Receiver, com.vaadin.ui.Upload.SucceededListener {
        public File file;
        private String filename;

        public OutputStream receiveUpload(String filename, String mimeType) {
            FileOutputStream fos;
            try {
                // Open the file for writing.
                this.filename = filename;
                file = new File(Sistema.getSistema().getImagePath().concat(filename));
                fos = new FileOutputStream(file);
            } catch (Exception e) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, C.MSJ_ERR_ONWORK_FILE, e.getMessage());
                return null;
            }
            return fos;
        }

        public void uploadSucceeded(com.vaadin.ui.Upload.SucceededEvent event) {
            if (filename != null && !filename.isEmpty()) {
                setValue(filename);
            }
        }
    }
    */

    private Component createComponent(String mimeType, String fileName,
                                      InputStream stream) {
        if (mimeType.startsWith("text")) {
            String text = "";
            try {
                text = IOUtils.toString(stream, "UTF-8");
            } catch (IOException e) {
                text = "exception reading stream";
            }
            return new Text(text);
        } else if (mimeType.startsWith("image")) {
            Image image = new Image();
            try {

                byte[] bytes = IOUtils.toByteArray(stream);
                image.getElement().setAttribute("src", new StreamResource(
                        fileName, () -> new ByteArrayInputStream(bytes)));
                try (ImageInputStream in = ImageIO.createImageInputStream(
                        new ByteArrayInputStream(bytes))) {
                    final Iterator<ImageReader> readers = ImageIO
                            .getImageReaders(in);
                    if (readers.hasNext()) {
                        ImageReader reader = readers.next();
                        try {
                            reader.setInput(in);
                            image.setWidth(reader.getWidth(0) + "px");
                            image.setHeight(reader.getHeight(0) + "px");
                        } finally {
                            reader.dispose();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return image;
        }
        Div content = new Div();
        String text = String.format("Mime type: '%s'\nSHA-256 hash: '%s'",
                mimeType, MessageDigestUtil.sha256(stream.toString()));
        content.setText(text);
        return new Div();

    }

    private void showOutput(String text, Component content,
                            HasComponents outputContainer) {
        HtmlComponent p = new HtmlComponent(Tag.P);
        p.getElement().setText(text);
        outputContainer.add(p);
        outputContainer.add(content);
    }
}