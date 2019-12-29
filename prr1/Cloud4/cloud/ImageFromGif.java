package cloud;

import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.gif.GIFImageReaderSpi;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ImageFromGif {

    public static void main(String[] args) {

        //Choose file to process
        File file = new File("tabs.gif");

        //Create arraylist for all images
        ArrayList<BufferedImage> images = new ArrayList();

        //try to get frames from file to arraylist
        try {
            images = getFrames(file);
        } catch (Exception e) {
            //print error and stop program on error
            e.printStackTrace();
            return;
        }

        //get width, height and framecount
        int width = images.get(0).getWidth();
        int height = images.get(0).getHeight();
        int frameCount = images.size();

        //print width, height and framecount
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Frame Count: " + frameCount);

        //Initiate output image as first image in array
        BufferedImage outImage = images.get(0);

        //loop through all but first frames
        for (int i = 1; i < frameCount; i++) {

            //get current frame
            BufferedImage image = images.get(i);

            //loop through pixels on x axis
            for (int x = 0; x < image.getWidth(); x++) {

                //loop through pixels on y axis
                for (int y = 0; y < image.getHeight(); y++) {

                    int outColor = outImage.getRGB(x, y);
                    int outBrightness = colorToCombinedRGB(outColor);

                    System.out.println("frame: "+i+" x: "+x+" y: "+y+" imagewidth: "+image.getWidth()+" originwidth: "+width);
                    int imageColor = image.getRGB(x, y);
                    int imageBrightness = colorToCombinedRGB(imageColor);

                    if (imageBrightness < outBrightness) {
                        outImage.setRGB(x, y, imageColor);
                    }

                }
            }
        }

        saveImage(outImage);
    }


    public static void saveImage(BufferedImage image) {
        try {
            // retrieve image
            File outputfile = new File("saved.png");
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String canonicalFilename, String text) throws IOException {
        File file = new File(canonicalFilename);
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(text);
        out.close();
    }

    /**
     * Takes a strange color value and returns a combined value of 8bit RGB values
     *
     * @param colorIn
     * @return
     */
    public static int colorToCombinedRGB(int colorIn) {
        int red = (colorIn & 0x00ff0000) >> 16;
        int green = (colorIn & 0x0000ff00) >> 8;
        int blue = colorIn & 0x000000ff;

        int outBrightness = red + blue + green;

        return outBrightness;
    }

    /**
     * got this from stackoverflow https://stackoverflow.com/a/8935070 https://stackoverflow.com/a/16234122
     * don't know how it works but it does
     *
     * @param gif
     * @return
     * @throws IOException
     */
    public static ArrayList<BufferedImage> getFrames(File gif) throws IOException {
        ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
        ImageReader ir = new GIFImageReader(new GIFImageReaderSpi());
        ir.setInput(ImageIO.createImageInputStream(gif));
        for (int i = 0; i < ir.getNumImages(true); i++)
            frames.add(ir.read(i));
        return frames;
    }
}
