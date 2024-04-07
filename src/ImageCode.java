import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageCode {

    // Array of characters to be used for generating the verification code
    static String[] strs = { "a","b","c","d","e","f","g","h",
            "i","j","k", "m","n","p","q","r","s","t","u",
            "v","w","x","y","z","2","3","4","5","6","7","8","9"};

    // The main method where the program starts execution
    public static void main(String[] args){

        // Define the width and height of the image
        int w = 150;
        int h = 50;

        // Create a BufferedImage object for the verification image
        BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = image.getGraphics();

        // Set the background color and fill the rectangle area of the image
        g.setColor(Color.yellow);
        g.fillRect(0,0,w,h);

        // Set the font color and the font style for the characters
        g.setColor(Color.red);
        g.setFont(new Font("Calibri", Font.BOLD,30));

        // Create an instance of Random class for generating random numbers
        Random random = new Random();

        // Starting coordinates for the first character
        int x = 30;
        int y = 30;

        // Draw 4 random characters on the image
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(strs.length);
            String str = strs[num];
            g.drawString(str,x,y);
            x += 25;  // Increment the x-coordinate for the next character
        }

        // Draw 10 random lines on the image to make the characters less readable by automated systems
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++){
            int x1 = random.nextInt(30);
            int y1 = random.nextInt(50);

            int x2 = random.nextInt(30)+120;
            int y2 = random.nextInt(50);
            g.drawLine(x1,y1,x2,y2);
        }

        // Write the image to a file
        try {
            ImageIO.write(image, "jpg", new File("D:\\develop\\Projects\\JavaVerificationCode\\image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
