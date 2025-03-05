package view;

import model.Situation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public abstract class CalculatorButton extends JButton implements ActionListener {

    protected Situation situation;
    final Color color = Color.CYAN;

    protected CalculatorButton(String text, Situation situation) {
        super(text);
        this.situation = situation;

        setPreferredSize(new Dimension(40, 40));

        setBackground(Color.WHITE);
        setOpaque(true);
        setBorderPainted(false);

        setFont(new Font("Arial", Font.BOLD, 35));
        setForeground(Color.BLACK);

        addActionListener(this);

    }

    protected void setColor(Color color) {
        setBackground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        transition();
    }

    protected abstract void transition();

}
