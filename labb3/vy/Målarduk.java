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
import static labb3.verktyg.Grafik.fillCircle;

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
		for (Rum rum : enNivå.getAllRoom()) {
			ritaRum(g, rum);
			ritaGångarFrånRum(g, rum);
			for (Väderstreck riktning : Väderstreck.values()) {
				if (rum.finnsUtgångÅt(riktning)) {
					Gång gång = rum.gångenÅt(riktning);
					ritaGång(g, gång);
				}
			}
		}
		ritaMarkörFörVarAnvändarenÄr(g);

		// För att underlätta finns hjälpmetoder som ska skrivas klara. Studera
		// noga bilderna i labbinstruktionen för att få fram formlerna för
		// bas- och pivotpunkternas koordinater. Använd ritmetoderna i klassen
		// labb3.verktyg.Grafik. Anropa hjälpmetoderna från paintComponent.
	}

	private void ritaRum(Graphics g, Rum ettRum) {
		g.setColor(ettRum.getGolvfärg());
		g.fillRect(ettRum.getPunkt().x(), ettRum.getPunkt().y(), ettRum.getBredd(), ettRum.getHöjd());

		int x = ettRum.getPunkt().x();
		int y = ettRum.getPunkt().y();
		int bredd = ettRum.getBredd();
		int höjd = ettRum.getHöjd();

		Punkt NV = new Punkt(x , y);
		Punkt NO = new Punkt(x + bredd, y);
		Punkt SV = new Punkt(x, y + höjd);
		Punkt SO = new Punkt(x + bredd, y + höjd);

		drawThickLine(g, new Punkt(NV.x() - HALV_VÄGGTJOCKLEK, NV.y()), new Punkt(NO.x() + HALV_VÄGGTJOCKLEK, NO.y()), VÄGGTJOCKLEK, VÄGGFÄRG);
		drawThickLine(g, new Punkt(NV.x(), NV.y() - HALV_VÄGGTJOCKLEK), new Punkt(SV.x(), SV.y() + HALV_VÄGGTJOCKLEK), VÄGGTJOCKLEK, VÄGGFÄRG);
		drawThickLine(g, new Punkt(SV.x() - HALV_VÄGGTJOCKLEK, SV.y()), new Punkt(SO.x() + HALV_VÄGGTJOCKLEK, SO.y()), VÄGGTJOCKLEK, VÄGGFÄRG);
		drawThickLine(g, new Punkt(NO.x(), NO.y() - HALV_VÄGGTJOCKLEK), new Punkt(SO.x(), SO.y() + HALV_VÄGGTJOCKLEK), VÄGGTJOCKLEK, VÄGGFÄRG);
	}

	private void ritaGångarFrånRum(Graphics g, Rum ettRum) {
		for (Väderstreck riktning : Väderstreck.values()) {
			if (ettRum.finnsUtgångÅt(riktning)) {
				drawThickLine(g, baspunkt(ettRum, riktning), pivotpunkt(ettRum, riktning), VÄGGTJOCKLEK, GÅNGFÄRG);
				fillCircle(g, pivotpunkt(ettRum, riktning), HALV_VÄGGTJOCKLEK, GÅNGFÄRG);
			}
		}
	}

	private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
		switch (enRiktning) {
			case NORR: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + HALV_VÄGGTJOCKLEK);
			case ÖSTER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd() - HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y() + ettRum.getHöjd()/2);
			case SÖDER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + ettRum.getHöjd() - HALV_VÄGGTJOCKLEK);
			case VÄSTER: return new Punkt(ettRum.getPunkt().x() + HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y()+ettRum.getHöjd()/2);
			default: return null;
		}

	}

	private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
		switch (enRiktning) {
			case NORR: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() - VÄGGTJOCKLEK);
			case ÖSTER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd() + VÄGGTJOCKLEK, ettRum.getPunkt().y() + ettRum.getHöjd()/2);
			case SÖDER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + ettRum.getHöjd() + VÄGGTJOCKLEK);
			case VÄSTER: return new Punkt(ettRum.getPunkt().x() - VÄGGTJOCKLEK, ettRum.getPunkt().y()+ettRum.getHöjd()/2);
			default: return null;
		}
	}

	private void ritaGång(Graphics g, Gång enGång) {
		drawThickLine(g, pivotpunkt(enGång.getFrån(), enGång.getRiktningUtUrFrån()), pivotpunkt(enGång.getTill(), enGång.getRiktningInITill()), VÄGGTJOCKLEK, GÅNGFÄRG);
	}

	private void ritaMarkörFörVarAnvändarenÄr(Graphics g) {
		Punkt mitten = new Punkt(enNivå.getRoom().getPunkt().x() + enNivå.getRoom().getBredd()/2, enNivå.getRoom().getPunkt().y()+enNivå.getRoom().getHöjd()/2);
		fillCircle(g, mitten, HALV_VÄGGTJOCKLEK, VÄGGFÄRG);

	}
}
