package cloud;

import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.gif.GIFImageReaderSpi;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
            BufferedImage image = images.get(1);

            //loop through pixels on x axis
            for (int x = 0; x < width; x++) {

                //loop through pixels on y axis
                for (int y = 0; y < height; y++) {

                    int outColor = outImage.getRGB(x, y);
                    int outBrightness = colorToCombinedRGB(outImage.getRGB(x, y));

                    //System.out.println("frame: "+i+" x: "+x+" y: "+y+" imagewidth: "+image.getWidth()+" originwidth: "+width);
                    int imageColor = image.getRGB(x, y);
                    int imageBrightness = colorToCombinedRGB(image.getRGB(x, y));

                    if (outColor != imageColor) {
                        System.out.println("NOT EQUAL!");
                    }

                    //System.out.println("frame: "+i+" x: "+x+" y: "+y+" imagebri: "+imageBrightness+" outbri: "+outBrightness);
                    if (imageBrightness < outBrightness) {
                        outImage.setRGB(x, y, imageColor);
                    }



                }
            }
        }

        saveImage(images.get(1));

        for (int i = 0; i < 30; i++) {
            try {
                ImageIO.write(images.get(i), "PNG", new File( i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
     * got this from stackoverflow https://stackoverflow.com/a/10627458
     * don't know how it works but it does
     *
     * @param gif
     * @return
     * @throws IOException
     */
    public static ArrayList<BufferedImage> getFrames(File gif) throws IOException {

        ArrayList<BufferedImage> images = new ArrayList();

        try {
            String[] imageatt = new String[]{
                    "imageLeftPosition",
                    "imageTopPosition",
                    "imageWidth",
                    "imageHeight"
            };

            ImageReader reader = (ImageReader)ImageIO.getImageReadersByFormatName("gif").next();
            ImageInputStream ciis = ImageIO.createImageInputStream(new File("tabs.gif"));
            reader.setInput(ciis, false);

            int noi = reader.getNumImages(true);
            BufferedImage master = null;

            for (int i = 0; i < noi; i++) {
                BufferedImage image = reader.read(i);
                IIOMetadata metadata = reader.getImageMetadata(i);

                Node tree = metadata.getAsTree("javax_imageio_gif_image_1.0");
                NodeList children = tree.getChildNodes();

                for (int j = 0; j < children.getLength(); j++) {
                    Node nodeItem = children.item(j);

                    if(nodeItem.getNodeName().equals("ImageDescriptor")){
                        Map<String, Integer> imageAttr = new HashMap<String, Integer>();

                        for (int k = 0; k < imageatt.length; k++) {
                            NamedNodeMap attr = nodeItem.getAttributes();
                            Node attnode = attr.getNamedItem(imageatt[k]);
                            imageAttr.put(imageatt[k], Integer.valueOf(attnode.getNodeValue()));
                        }
                        if(i==0){
                            master = new BufferedImage(imageAttr.get("imageWidth"), imageAttr.get("imageHeight"), BufferedImage.TYPE_INT_ARGB);
                        }
                        master.getGraphics().drawImage(image, imageAttr.get("imageLeftPosition"), imageAttr.get("imageTopPosition"), null);
                    }
                }
                images.add(master);
                ImageIO.write(master, "GIF", new File( i + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return images;
    }
}
