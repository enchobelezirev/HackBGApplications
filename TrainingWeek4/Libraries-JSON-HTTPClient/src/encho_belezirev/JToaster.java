package encho_belezirev;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class JToaster {

    public static void main(String[] args) {
        Toaster toast = new Toaster();
        Path pImage = Paths.get("C:\\Users\\Belezirev\\Desktop\\dog.jpg");
        BufferedImage imgDog = null;
        try {
            imgDog = ImageIO.read(pImage.toFile());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        toast.setToasterHeight(imgDog.getHeight());
        toast.setToasterWidth(imgDog.getWidth());
        toast.setBackgroundImage(imgDog);
        toast.setMessageColor(Color.WHITE);
        toast.showToaster("Get up right now!");
        toast.setDisplayTime(10000);
    }

}
