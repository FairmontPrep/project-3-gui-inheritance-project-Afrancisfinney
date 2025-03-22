import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class PokeballBase extends JPanel {
    protected String description;
    protected BufferedImage image;

    public PokeballBase(String desc, String imagePath) {
        this.description = desc;
        loadImage(imagePath);
        setOpaque(false); 
    }

    private void loadImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.out.println("Image not found: " + imagePath);
        }
    }

    public String getDescription() {
        return description;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
