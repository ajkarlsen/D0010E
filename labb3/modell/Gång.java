package labb3.modell;

public class Gång {

	// TODO: Lägg till tillståndsvariabler för att hålla parametrarna till
	// konstruktorn. 

	private Rum från;
	private Väderstreck riktningUtUrFrån;
	private Rum till;
	private Väderstreck riktningInITill;

	public Gång(Rum från, Väderstreck riktningUtUrFrån, Rum till,
			Väderstreck riktningInITill) {
		this.från = från;
		this.riktningUtUrFrån = riktningUtUrFrån;
		this.till = till;
		this.riktningInITill = riktningInITill;
		// TODO: Tilldela tillståndsvariablerna parametervärdena.
	}


	public Rum getFrån(){
		return från;
	}
	public Väderstreck getRiktningUtUrFrån(){
		return riktningUtUrFrån;
	}
	public Rum getTill(){
		return till;
	}
	public Väderstreck getRiktningInITill(){
		return riktningInITill;
	}
	// TODO: Lägg till instansmetoder som returnerar tillståndsvariablernas
	// värden.
}
