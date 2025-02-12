package labb3.vy;

import java.awt.Graphics;

import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.modell.Väderstreck;
import labb3.verktyg.Punkt;

// TODO: Ändra nästa rad så att en Målarduk "är-en" JPanel. 
public class Målarduk {

	private final Nivå enNivå;

	public Målarduk(Nivå enNivå) {
		this.enNivå = enNivå;
		// TODO: Sätt bakgrundsfärgen på this till MARKFÄRG.
		// TODO: Anropa metoden setFocusable på this och med argumentet true.
		// Detta behövs för att lyssnaren i programmet ska reagera.
	}

	// TODO: Lätt till @Override på metoden nedan.
	protected void paintComponent(Graphics g) {
		// TODO Lägg till ett anrop till paintComponent i omedelbara
		// överklassen (JPanel). Skicka med g som argument.

		// TODO: Lägg till kod som ritar ut en grafisk vy av enNivå.
		//
		// För att underlätta finns hjälpmetoder som ska skrivas klara. Studera
		// noga bilderna i labbinstruktionen för att få fram formlerna för
		// bas- och pivotpunkternas koordinater. Använd ritmetoderna i klassen
		// labb3.verktyg.Grafik. Anropa hjälpmetoderna från paintComponent.
	}

	private void ritaRum(Graphics g, Rum ettRum) {

	}

	private void ritaGångarFrånRum(Graphics g, Rum ettRum) {

	}

	private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
		return null; /* endast här för att Eclipse inte ska klaga */
	}

	private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
		return null; /* endast här för att Eclipse inte ska klaga */
	}

	private void ritaGång(Graphics g, Gång enGång) {

	}

	private void ritaMarkörFörVarAnvändarenÄr(Graphics g) {

	}
}
