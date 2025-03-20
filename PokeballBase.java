import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

abstract class PokeballBase extends JPanel {
    private BufferedImage backgroundImage;
    protected String description;

    public PokeballBase() {
        loadImage();
    }

    protected abstract void loadImage();

    protected void setBackgroundImage(String filePath) {
        try {
            backgroundImage = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    protected void appendDescription(String text) {
        description = (description == null) ? text : description + " " + text;
    }

    public String getDescription() {
        return description;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }
}
