import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PokeballGUI {
    private PokeballTop pokeball;
    private JLabel label;
    private boolean isUltraBall;

    public PokeballGUI() {
        pokeball = new PokeballTop();
        label = new JLabel("Congratulations! You got an Ultra Ball", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        // Initially set to Regular Ball
        isUltraBall = false;

        // Add MouseListener to handle color switching and Pokeball type change
        pokeball.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle the Pokeball type
                togglePokeballType();
                // Switch the color
                pokeball.switchColor();
            }
        });
    }

    private void togglePokeballType() {
        // Toggle between Regular Ball and Ultra Ball
        isUltraBall = !isUltraBall;

        // Update the label based on the new Pokeball type
        String message = isUltraBall ? "You Got the Regular Ball" : "Congratulations! You got an Ultra Ball";
        label.setText(message);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Pokeball GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350); // Increased size to fit the label

        // Use BorderLayout to position elements
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.NORTH);
        frame.add(pokeball, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PokeballGUI gui = new PokeballGUI();
            gui.createAndShowGUI();
        });
    }
}
