package labb3.modell;

import labb3.verktyg.Punkt;

import java.awt.Color;
import static labb3.GlobalaKonstanter.ANTAL_VÄDERSTRECK;


public class Rum {

	private Color golvfärg;
	private int bredd;
	private int höjd;
	private Punkt punkt;

	private Gång[] gångar = new Gång[ANTAL_VÄDERSTRECK]; // Lista som sparar gångar för alla vädersträck

	public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {

		this.golvfärg = golvfärg;
		this.bredd = bredd;
		this.höjd = höjd;
        this.punkt = new Punkt(övX, övY);
	}


	public Color getGolvfärg(){
		return golvfärg;
	}

	public int getBredd() {
		return bredd;
	}

	public int getHöjd() {
		return höjd;
	}

	public Punkt getPunkt() {
		return punkt;
	}


	public boolean finnsUtgångÅt(Väderstreck väderstreck) { // Kollar ifall det finns utgång åt väderstreck i parameter
		boolean finns = gångar[väderstreck.index()] != null;
		return finns;
	}



	public Gång gångenÅt(Väderstreck väderstreck) { // Returnerar gången åt ett givet väderstreck
		if (finnsUtgångÅt(väderstreck)) {
			return gångar[väderstreck.index()];
		} else {
			throw new IllegalArgumentException("Inga gångar boss");
		}
	}

	public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
								  Rum till, Väderstreck riktningInITill) {

		Gång gångFrånTill = new Gång(från, riktningUtUrFrån, till, riktningInITill); // Kopplar två gångar från alla lådor.
		Gång gångTillFrån = new Gång(till, riktningInITill, från, riktningUtUrFrån); // Två stycken för att det måste gå att gå åt båda hållen.

		från.gångar[riktningUtUrFrån.index()] = gångFrånTill;
		till.gångar[riktningInITill.index()] = gångTillFrån;

	}
}
