import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;
class PokeballTop extends PokeballButton {
    private BufferedImage topImage;
    private BufferedImage alternateImage;
    private boolean isAlternate;

    public PokeballTop() {
        super();
        appendDescription("with a Color");
        loadRandomImage();
    }

    private void loadRandomImage() {
        try {
            topImage = ImageIO.read(new File("Color Fill 1.png"));
            alternateImage = ImageIO.read(new File("Layer 3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        isAlternate = new Random().nextBoolean();
    }

    public void switchColor() {
        isAlternate = !isAlternate;
        appendDescription(isAlternate ? "Switched to Alt Color" : "Switched to Default Color");
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isAlternate && alternateImage != null) {
            g.drawImage(alternateImage, 0, 0, this);
        } else if (topImage != null) {
            g.drawImage(topImage, 0, 0, this);
        }
    }
}
