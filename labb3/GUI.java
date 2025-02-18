package labb3;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import labb3.kontroll.Tangentbordslyssnare;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.vy.Målarduk;

import javax.swing.*;


public class GUI extends JFrame implements Observer {

	private Målarduk målarduk;

	public GUI(Nivå enNivå) {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enNivå.addObserver(this);
		målarduk = new Målarduk(enNivå);

		int bredd = 0;
		int höjd = 0;

		for (Rum rum : enNivå.getAllRoom()) { // Säkerställer att inte spelplanen är för liten
			bredd += rum.getBredd();
			höjd += rum.getHöjd();
		}
		målarduk.setPreferredSize(new Dimension(bredd, höjd));

		målarduk.addKeyListener(new Tangentbordslyssnare(enNivå));

		this.setContentPane(målarduk);
		this.setVisible(true);
		this.pack();
	}


	@Override
	public void update(Observable o, Object arg) {
		this.målarduk.repaint();
	}
}
