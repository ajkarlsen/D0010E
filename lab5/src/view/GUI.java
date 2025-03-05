package view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GUI extends JFrame implements Observer {
    final Canvas canvas;

    public GUI() {

        canvas = new Canvas();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setPreferredSize(new Dimension(300, 350));

        this.setContentPane(canvas);
        this.setVisible(true);
        this.pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.canvas.repaint();
    }
}

