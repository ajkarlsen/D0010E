package labb3.vy;

import java.awt.*;

import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.modell.Väderstreck;
import labb3.verktyg.Punkt;
import static labb3.GlobalaKonstanter.MARKFÄRG;
import javax.swing.*;

// TODO: Ändra nästa rad så att en Målarduk "är-en" JPanel. 
public class Målarduk extends JPanel {

	private final Nivå enNivå;

	public Målarduk(Nivå enNivå) {
		this.enNivå = enNivå;
		// TODO: Sätt bakgrundsfärgen på this till MARKFÄRG.
		this.setBackground(MARKFÄRG);
		// TODO: Anropa metoden setFocusable på this och med argumentet true.
		// Detta behövs för att lyssnaren i programmet ska reagera.
		this.setFocusable(true);
	}

	// TODO: Lätt till @Override på metoden nedan.
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Lägg till ett anrop till paintComponent i omedelbara
		// överklassen (JPanel). Skicka med g som argument.
		super.paintComponent(g);
		// TODO: Lägg till kod som ritar ut en grafisk vy av enNivå.
		//
		ritaRum(g, enNivå.getRoom());
		// För att underlätta finns hjälpmetoder som ska skrivas klara. Studera
		// noga bilderna i labbinstruktionen för att få fram formlerna för
		// bas- och pivotpunkternas koordinater. Använd ritmetoderna i klassen
		// labb3.verktyg.Grafik. Anropa hjälpmetoderna från paintComponent.
	}

	private void ritaRum(Graphics g, Rum ettRum) {
		g.setColor(ettRum.getGolvfärg());
		g.fillRect(ettRum.getPunkt().x(), ettRum.getPunkt().y(), ettRum.getBredd(), ettRum.getHöjd());
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
