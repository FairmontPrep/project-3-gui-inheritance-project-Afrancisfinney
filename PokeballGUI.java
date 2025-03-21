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
        label = new JLabel("You Got the Regular Ball", SwingConstants.CENTER); // Start with the Regular Ball
        label.setFont(new Font("Arial", Font.BOLD, 16));

        isUltraBall = false; // Ensure it starts as a Regular Ball

        // Mouse click toggles both the color and the message
        pokeball.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePokeballState();
            }
        });
    }

    private void togglePokeballState() {
        // Toggle state between Ultra Ball and Regular Ball
        isUltraBall = !isUltraBall;

        // Update the label message
        String message = isUltraBall ? "Congratulations! You got an Ultra Ball" : "You Got the Regular Ball";
        label.setText(message);

        // Set the corresponding image based on the state
        pokeball.setUltraBallMode(isUltraBall);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Pokeball GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350); 

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
