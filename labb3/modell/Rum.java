package labb3.modell;

import labb3.verktyg.Punkt;

import java.awt.Color;
import static labb3.GlobalaKonstanter.ANTAL_VÄDERSTRECK;


public class Rum {

	// TODO: Lägg till tillståndsvariabler.
	private Color golvfärg;
	private int bredd;
	private int höjd;
	private Punkt punkt;

	private Gång[] gångar = new Gång[ANTAL_VÄDERSTRECK];

	public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {
		// TODO: Kopiera parametrarna in i tillståndsvariablerna. (övX,övY) är
		// koordinaten för rummets övre vänstra hörn och lagras lämpligen som en
		// instans av klassen Punkt i paketet verktyg.
		this.golvfärg = golvfärg;
		this.bredd = bredd;
		this.höjd = höjd;
        this.punkt = new Punkt(övX, övY);
	}

	// TODO: Skriv "getters", metoder som returnerar tillståndsvariablernas
	// värden.
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


	// TODO: Skriv instansmetoden
	//
	// finnsUtgångÅt(Väderstreck väderstreck)
	public boolean finnsUtgångÅt(Väderstreck väderstreck) {
		boolean finns = gångar[väderstreck.index()] != null;
		return finns;
	}
	//
	// som ska kontrollera om det från ett rum finns en utgång åt visst
	// väderstreck.

	// TODO: Skriv instansmetoden
	//
	// Gång gångenÅt(Väderstreck väderstreck) som
	public Gång gångenÅt(Väderstreck väderstreck) {
		if (finnsUtgångÅt(väderstreck)) {
			return gångar[väderstreck.index()];
		} else {
			throw new IllegalArgumentException("Inga gångar boss");
		}
	}
	//
	// returnerar den gång som leder från ett rum i riktning väderstreck. Om
	// sådan gång saknas ska ett undantag kastas med lämpligt felmeddelande.

	// TODO: Skrivklar metoden nedan som kopplar ihop två rum med en gång.

	public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
								  Rum till, Väderstreck riktningInITill) {

		Gång gångFrånTill = new Gång(från, riktningUtUrFrån, till, riktningInITill);
		Gång gångTillFrån = new Gång(till, riktningInITill, från, riktningUtUrFrån);


		System.out.println("Kopplar gång från " + från + " till " + till);
		från.gångar[riktningUtUrFrån.index()] = gångFrånTill;
		till.gångar[riktningInITill.index()] = gångTillFrån;


	}

	public static void main(String[] args) {

	}
}
