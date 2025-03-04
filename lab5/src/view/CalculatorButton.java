package view;

import model.Situation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;


public abstract class CalculatorButton extends JButton implements ActionListener {

    protected Situation situation;

    public CalculatorButton(String text, Situation situation) {
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

    public void setColor(Color color) {
        setBackground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        transition();
    }

    public abstract void transition();

}
