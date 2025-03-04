package view;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;

public class Display extends JLabel {

    public Display() {
        // Sätt textjustering till höger
        setHorizontalAlignment(JLabel.RIGHT);

        // Sätt ljus bakgrundsfärg
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);  // Viktigt för att bakgrundsfärgen ska synas

        // Sätt ett tydligt typsnitt (Arial, fet stil, stor storlek)
        setFont(new Font("Arial", Font.BOLD, 35));

        // Sätt en svart ram med 2 pixlar tjocklek
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBorder(border);


    }
}
