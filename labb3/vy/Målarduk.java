package labb3.vy;

import java.awt.*;

import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.modell.Väderstreck;
import labb3.verktyg.Punkt;

import javax.swing.*;

import static labb3.GlobalaKonstanter.*;
import static labb3.verktyg.Grafik.drawThickLine;

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
		for (int i = 0; i <= enNivå.getAllRoom().size()-1; i++) {
			ritaRum(g, enNivå.getAllRoom().get(i));
			ritaGångarFrånRum(g, enNivå.getAllRoom().get(i));
		}
		// För att underlätta finns hjälpmetoder som ska skrivas klara. Studera
		// noga bilderna i labbinstruktionen för att få fram formlerna för
		// bas- och pivotpunkternas koordinater. Använd ritmetoderna i klassen
		// labb3.verktyg.Grafik. Anropa hjälpmetoderna från paintComponent.
	}

	private void ritaRum(Graphics g, Rum ettRum) {
		g.setColor(ettRum.getGolvfärg());
		g.fillRect(ettRum.getPunkt().x(), ettRum.getPunkt().y(), ettRum.getBredd(), ettRum.getHöjd());

		Punkt NV = new Punkt(ettRum.getPunkt().x() - HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y() - HALV_VÄGGTJOCKLEK);
		Punkt NO = new Punkt(ettRum.getPunkt().x() + ettRum.getBredd() + HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y() - HALV_VÄGGTJOCKLEK);
		Punkt SV = new Punkt(ettRum.getPunkt().x() - HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y()+ ettRum.getHöjd() + HALV_VÄGGTJOCKLEK);
		Punkt SO = new Punkt(ettRum.getPunkt().x() + ettRum.getBredd() + HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y() + ettRum.getHöjd() + HALV_VÄGGTJOCKLEK);

		drawThickLine(g, NV, NO, VÄGGTJOCKLEK, VÄGGFÄRG);
		drawThickLine(g, NV, SV, VÄGGTJOCKLEK, VÄGGFÄRG);
		drawThickLine(g, SV, SO, VÄGGTJOCKLEK, VÄGGFÄRG);
		drawThickLine(g, NO, SO, VÄGGTJOCKLEK, VÄGGFÄRG);

	}

	private void ritaGångarFrånRum(Graphics g, Rum ettRum) {
		g.setColor(GÅNGFÄRG);


	}

	private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
		switch (enRiktning) {
			case NORR: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y());
			case ÖSTER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd(), ettRum.getPunkt().y() + ettRum.getHöjd()/2);
			case SÖDER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + ettRum.getHöjd());
			case VÄSTER: return new Punkt(ettRum.getPunkt().x(), ettRum.getPunkt().y()+ettRum.getHöjd()/2);
			default: return null;
		}

	}

	private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
		return null; /* endast här för att Eclipse inte ska klaga */
	}

	private void ritaGång(Graphics g, Gång enGång) {

	}

	private void ritaMarkörFörVarAnvändarenÄr(Graphics g) {

	}
}
