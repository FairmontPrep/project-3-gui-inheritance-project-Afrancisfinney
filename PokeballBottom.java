
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
class PokeballBottom extends PokeballBase {
    private BufferedImage bottomImage;

    public PokeballBottom() {
        super();
        appendDescription("Pokeball Bottom");
    }

    @Override
    protected void loadImage() {
        setBackgroundImage("Background.png");
        try {
            bottomImage = ImageIO.read(new File("Layer 2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bottomImage != null) {
            g.drawImage(bottomImage, 0, 0, this);
        }
    }
}

// Grandchild class: Adds button
class PokeballButton extends PokeballBottom {
    private BufferedImage buttonImage;

    public PokeballButton() {
        super();
        appendDescription("with Button");
    }

    @Override
    protected void loadImage() {
        super.loadImage();
        try {
            buttonImage = ImageIO.read(new File("Layer 1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (buttonImage != null) {
            g.drawImage(buttonImage, 0, 0, this);
        }
    }
}