import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class PokeballTop extends PokeballButton {
    private BufferedImage regularTopImage; // Regular Pokéball top
    private BufferedImage ultraTopImage;   // Ultra Ball top
    private boolean isUltraBall;

    public PokeballTop() {
        super();
        appendDescription("with a Color");
        loadImages();
        isUltraBall = false; // Default to Regular Ball
    }

    private void loadImages() {
        try {
            regularTopImage = ImageIO.read(new File("Color Fill 1.png")); // Regular red Pokéball top
            ultraTopImage = ImageIO.read(new File("Layer 3.png")); // Ultra Ball top
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUltraBallMode(boolean isUltraBall) {
        this.isUltraBall = isUltraBall;
        repaint(); // Ensure repaint happens immediately after the change
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw the correct top image based on whether it's an Ultra Ball or Regular Ball
        if (isUltraBall && ultraTopImage != null) {
            g.drawImage(ultraTopImage, 0, 0, this);
        } else if (regularTopImage != null) {
            g.drawImage(regularTopImage, 0, 0, this);
        }
    }
}
