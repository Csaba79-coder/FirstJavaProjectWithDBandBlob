package application.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ReadImage {

    public static final String FILEPATH = "src/main/resources/CsabaVadasz";
    public static final String IMAGE_FORMAT = ".png";

    public byte[] readImage(String filePath, String imageFormat) {

        try {
            File file = new File(filePath);
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, imageFormat, arrayOutputStream);
            return arrayOutputStream.toByteArray();
        } catch (IOException e) {
            return new byte[0];
        }
    }
}
