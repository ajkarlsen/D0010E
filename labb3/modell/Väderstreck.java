package labb3.modell;

public enum Väderstreck {
	NORR(0), ÖSTER(1), SÖDER(2), VÄSTER(3);
	private int heltal;

	Väderstreck(int i) {
		this.heltal = i;
	}

	public int index() {
		return this.heltal;
	}
}
