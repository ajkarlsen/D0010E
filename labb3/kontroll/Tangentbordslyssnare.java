package labb3.kontroll;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import labb3.modell.Nivå;
import labb3.modell.Väderstreck;

public class Tangentbordslyssnare implements KeyListener {
	private Nivå enNivå;

	public Tangentbordslyssnare(Nivå enNivå) {
		this.enNivå = enNivå;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		switch (key) {
			case KeyEvent.VK_W:
				enNivå.hoppaÅt(Väderstreck.NORR);
				System.out.println("W");
				break;
			case KeyEvent.VK_S:
				enNivå.hoppaÅt(Väderstreck.SÖDER);
				System.out.println("S");
				break;
			case KeyEvent.VK_A:
				enNivå.hoppaÅt(Väderstreck.VÄSTER);
				System.out.println("A");
				break;
			case KeyEvent.VK_D:
				enNivå.hoppaÅt(Väderstreck.ÖSTER);
				System.out.println("D");
				break;
			default:
				System.out.println("Använd WASD");
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Används inte men måste implementeras eftersom keyTyped finns i
		// gränssnittet KeyListener.

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Används inte men måste implementeras eftersom keyReleased finns is
		// gränssnittet KeyListener.
	}
}
