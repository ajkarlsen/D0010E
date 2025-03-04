package view;

import model.Situation;

import javax.swing.*;
import java.awt.*;
import model.Situation;

public class Canvas extends JPanel {
    final Display display;
    final Keypad keypad;
    final Situation situation;

    public Canvas() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.ORANGE);
        this.setFocusable(true);

        this.display = new Display();
        this.situation = new Situation(display);
        this.keypad = new Keypad(situation);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        display.setPreferredSize(new Dimension(this.getWidth(), 50));
        display.setText("0");
        this.add(display, c);

        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;
        this.add(keypad, c);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}