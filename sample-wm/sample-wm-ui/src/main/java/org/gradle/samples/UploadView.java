package org.gradle.samples;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.LegacyWrapper;
import com.vaadin.mpr.core.HasLegacyComponents;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import org.vaadin.easyuploads.UploadField;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Route("upload")
public class UploadView extends VerticalLayout implements HasLegacyComponents {

    public UploadView(){
        ImagePreviewField upload = new ImagePreviewField();
        upload.setCaption("Custom prview for images.");
        upload.setAcceptFilter("image/*");
        upload.setFieldType(UploadField.FieldType.BYTE_ARRAY);
        add(upload);
    }

    public class ImagePreviewField extends UploadField {
        @Override
        protected Image createDisplayComponent() {
            Image image = new Image();
            image.setHeight("100px");
            return image;
        }

        @Override
        protected void updateDisplayComponent() {
            try {
                Image image = (Image) display;
                // check if upload is an image
                if (ImageIO.read(new ByteArrayInputStream((byte[]) getValue())) != null) {
                    // Update the image according to
                    // https://vaadin.com/book/vaadin7/-/page/components.embedded.html
                    SimpleDateFormat df = new SimpleDateFormat(
                            "yyyyMMddHHmmssSSS");
                    String filename = df.format(new Date()) + getLastFileName();
                    StreamResource resource = new StreamResource(
                            new ImageSource((byte[]) getValue()), filename);
                    resource.setCacheTime(0);
                    image.setSource(resource);
                } else {
                    image.setSource(null);
                    setValue(null);
                }

                image.markAsDirty();
                if (display.getParent() == null) {
                    getRootLayout().addComponent(display);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public class ImageSource implements StreamResource.StreamSource {
            private byte[] buffer;

            public ImageSource(byte[] image) {
                this.buffer = image;
            }

            @Override
            public InputStream getStream() {
                return new ByteArrayInputStream(buffer);
            }
        }
    }

}
