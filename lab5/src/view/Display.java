package view;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;

public class Display extends JLabel {

    public Display() {
        setHorizontalAlignment(JLabel.RIGHT);

        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);

        setFont(new Font("Arial", Font.BOLD, 35));

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBorder(border);


    }
}
