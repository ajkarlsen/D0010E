package labb3.verktyg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static labb3.verktyg.Grafik.*;

/**
 * @author Håkan Jonsson
 */
public class GrafikDemo extends JFrame {

	private class Yta extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			fillCircle(g, new Punkt(125, 50), 25, Color.RED);
			fillCircle(g, new Punkt(125, 50), 2, Color.BLACK);

			drawThickLine(g, new Punkt(250, 50), new Punkt(450, 50), 50,
					Color.BLACK);
			drawThickLine(g, new Punkt(250, 50), new Punkt(450, 50), 2,
					Color.YELLOW);

			fillCircle(g, new Punkt(125, 175), 50, Color.RED);
			fillCircle(g, new Punkt(125, 175), 2, Color.BLACK);

			drawThickLine(g, new Punkt(250, 175), new Punkt(450, 175), 100,
					Color.BLACK);
			drawThickLine(g, new Punkt(250, 175), new Punkt(450, 175), 2,
					Color.YELLOW);

			fillCircle(g, new Punkt(125, 350), 75, Color.RED);
			fillCircle(g, new Punkt(125, 350), 2, Color.BLACK);

			drawThickLine(g, new Punkt(250, 350), new Punkt(450, 350), 150,
					Color.BLACK);
			drawThickLine(g, new Punkt(250, 350), new Punkt(450, 350), 2,
					Color.YELLOW);
		}
	}

	public GrafikDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Yta canvas = new Yta();
		canvas.setPreferredSize(new Dimension(500, 450));
		canvas.setBackground(Color.LIGHT_GRAY);

		setContentPane(canvas);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new GrafikDemo();
	}
}