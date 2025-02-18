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

public class Målarduk extends JPanel {

	private final Nivå enNivå;

	public Målarduk(Nivå enNivå) {
		this.enNivå = enNivå;
		this.setBackground(MARKFÄRG);
		this.setFocusable(true);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		for (Rum rum : enNivå.getAllRoom()) { // Loopar genom alla rum och ritar ut dem och bas-pivotpunkterna
			ritaRum(g, rum);
			ritaGångarFrånRum(g, rum);
			for (Väderstreck riktning : Väderstreck.values()) { // Loopar genom alla väderstreck och ritar gång om en sådan finns
				if (rum.finnsUtgångÅt(riktning)) {
					Gång gång = rum.gångenÅt(riktning);
					ritaGång(g, gång);
				}
			}
		}
		ritaMarkörFörVarAnvändarenÄr(g);

	}

	private void ritaRum(Graphics g, Rum ettRum) { //Ritar ut rummen och väggarna

		g.setColor(ettRum.getGolvfärg());
		g.fillRect(ettRum.getPunkt().x(), ettRum.getPunkt().y(), ettRum.getBredd(), ettRum.getHöjd()); // Golv

		int x = ettRum.getPunkt().x();
		int y = ettRum.getPunkt().y();
		int bredd = ettRum.getBredd();
		int höjd = ettRum.getHöjd();

		Punkt NV = new Punkt(x , y);
		Punkt NO = new Punkt(x + bredd, y);
		Punkt SV = new Punkt(x, y + höjd);
		Punkt SO = new Punkt(x + bredd, y + höjd);

		drawThickLine(g, new Punkt(x - HALV_VÄGGTJOCKLEK, y), new Punkt(NO.x() + HALV_VÄGGTJOCKLEK, NO.y()), VÄGGTJOCKLEK, VÄGGFÄRG); // Väggar
		drawThickLine(g, new Punkt(NV.x(), NV.y() - HALV_VÄGGTJOCKLEK), new Punkt(SV.x(), SV.y() + HALV_VÄGGTJOCKLEK), VÄGGTJOCKLEK, VÄGGFÄRG);
		drawThickLine(g, new Punkt(SV.x() - HALV_VÄGGTJOCKLEK, SV.y()), new Punkt(SO.x() + HALV_VÄGGTJOCKLEK, SO.y()), VÄGGTJOCKLEK, VÄGGFÄRG);
		drawThickLine(g, new Punkt(NO.x(), NO.y() - HALV_VÄGGTJOCKLEK), new Punkt(SO.x(), SO.y() + HALV_VÄGGTJOCKLEK), VÄGGTJOCKLEK, VÄGGFÄRG);
	}

	private void ritaGångarFrånRum(Graphics g, Rum ettRum) { // Ritar ut linje från baspunkter till pivotpunkter
		for (Väderstreck riktning : Väderstreck.values()) {
			if (ettRum.finnsUtgångÅt(riktning)) {
				drawThickLine(g, baspunkt(ettRum, riktning), pivotpunkt(ettRum, riktning), VÄGGTJOCKLEK, GÅNGFÄRG);
				fillCircle(g, pivotpunkt(ettRum, riktning), HALV_VÄGGTJOCKLEK, GÅNGFÄRG);
			}
		}
	}

	private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) { // Definierar baspunkter
		switch (enRiktning) {
			case NORR: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + HALV_VÄGGTJOCKLEK);
			case ÖSTER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd() - HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y() + ettRum.getHöjd()/2);
			case SÖDER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + ettRum.getHöjd() - HALV_VÄGGTJOCKLEK);
			case VÄSTER: return new Punkt(ettRum.getPunkt().x() + HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y()+ettRum.getHöjd()/2);
			default: return null;
		}

	}

	private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) { // Definierar pivotpunkter
		switch (enRiktning) {
			case NORR: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() - VÄGGTJOCKLEK);
			case ÖSTER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd() + VÄGGTJOCKLEK, ettRum.getPunkt().y() + ettRum.getHöjd()/2);
			case SÖDER: return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + ettRum.getHöjd() + VÄGGTJOCKLEK);
			case VÄSTER: return new Punkt(ettRum.getPunkt().x() - VÄGGTJOCKLEK, ettRum.getPunkt().y()+ettRum.getHöjd()/2);
			default: return null;
		}
	}

	private void ritaGång(Graphics g, Gång enGång) { // Ritar ut gångar
		drawThickLine(g, pivotpunkt(enGång.getFrån(), enGång.getRiktningUtUrFrån()), pivotpunkt(enGång.getTill(), enGång.getRiktningInITill()), VÄGGTJOCKLEK, GÅNGFÄRG);
	}

	private void ritaMarkörFörVarAnvändarenÄr(Graphics g) { // Ritar ut punkt för användaren
		Punkt mitten = new Punkt(enNivå.getRoom().getPunkt().x() + enNivå.getRoom().getBredd()/2, enNivå.getRoom().getPunkt().y()+enNivå.getRoom().getHöjd()/2);
		fillCircle(g, mitten, HALV_VÄGGTJOCKLEK, ANVÄNDARFÄRG);

	}
}
