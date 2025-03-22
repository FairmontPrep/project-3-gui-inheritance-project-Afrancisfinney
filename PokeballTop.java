import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class PokeballTop extends PokeballBase {
    private boolean isUltraBall;
    private BufferedImage defaultImage;
    private BufferedImage ultraBallImage;

    public PokeballTop() {
        super("", "Color Fill 1.png");
        loadImages();
        isUltraBall = Math.random() < 0.5;
        updateImage();
    }

    private void loadImages() {
        try {
            defaultImage = ImageIO.read(new File("Color Fill 1.png"));
            ultraBallImage = ImageIO.read(new File("Layer 3.png"));
        } catch (IOException e) {
            System.out.println("Error loading images");
        }
    }

    private void updateImage() {
        if (isUltraBall) {
            image = ultraBallImage;
            description = "Ultra Ball Top Layer | Oh! You got a Ultra Pokeball";
        } else {
            image = defaultImage;
            description = "Regular Top Layer | Oh! You got a Regular Pokeball";
        }
        repaint();
    }

    public void toggleBall() {
        isUltraBall = !isUltraBall;
        updateImage();
    }

    public boolean isUltraBall() {
        return isUltraBall;
    }
}
