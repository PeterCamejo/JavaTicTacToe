package views;


import java.awt.image.BufferedImage;
import java.nio.Buffer;


/**
 * Implemented by Peter Camejo
 */
public class Assets {
    private static final int width = 94, height = 94; // TileSize - 6

    // Tokens
    public static BufferedImage X;
    public static BufferedImage O;

    //Numbers
    public static BufferedImage three;
    public static BufferedImage four;
    public static BufferedImage five;
    public static BufferedImage six;

    /* Methods */
    public static void init() {
        SpriteSheet XSheet = new SpriteSheet(new ImageLoader().loadImage("/X.jpg"));
        SpriteSheet OSheet = new SpriteSheet(new ImageLoader().loadImage("/O.jpg"));
        SpriteSheet threeSheet = new SpriteSheet(new ImageLoader().loadImage("/three.png"));
        SpriteSheet fourSheet = new SpriteSheet(new ImageLoader().loadImage("/four.png"));
        SpriteSheet fiveSheet = new SpriteSheet(new ImageLoader().loadImage("/five.png"));
        SpriteSheet sixSheet = new SpriteSheet(new ImageLoader().loadImage("/six.png"));



        X = XSheet.crop(0 , 0 , width , height );
        O = OSheet.crop(0 , 0 , width , height);

        three = threeSheet.crop(0 , 0 , width , height);
        four = fourSheet.crop(0 , 0 , width , height);
        five = fiveSheet.crop(0 , 0 , width , height);
        six = sixSheet.crop(0 , 0 , width , height);

    }
}
