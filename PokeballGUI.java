import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PokeballGUI {
    private PokeballBackground background;
    private PokeballBase bottom;
    private PokeballTop top;
    private JTextArea label;

    public PokeballGUI() {
        JFrame frame = new JFrame("Pokeball GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 400);
        frame.setLayout(null);

        background = new PokeballBackground();
        bottom = new PokeballBase("Bottom Layer | ", "Layer 2.png");
        top = new PokeballTop();

        background.setBounds(10, 10, 300, 300);
        bottom.setBounds(10, 10, 300, 300);
        top.setBounds(10, 10, 300, 300);

        label = new JTextArea(getFullDescription());
        label.setBounds(10, 310, 300, 50);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setWrapStyleWord(true);
        label.setLineWrap(true);
        label.setOpaque(false);
        label.setEditable(false);
        label.setFocusable(false);

        frame.add(background);
        frame.add(bottom);
        frame.add(top);
        frame.add(label);

        label.setText(getFullDescription()); // Ensure updated message displays at startup

        top.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                top.toggleBall();
                label.setText(getFullDescription());
            }
        });

        frame.setVisible(true);
    }

    private String getFullDescription() {
        return background.getDescription() + bottom.getDescription() + top.getDescription();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PokeballGUI());
    }
}
