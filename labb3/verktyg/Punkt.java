package labb3.verktyg;

/**
 * Icke muterbar klass för punkter.
 * 
 * @author Håkan Jonsson
 */
public class Punkt {

	private final int x, y;

	public Punkt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public String toString() {
		return "(" + x() + "," + y() + ")";
	}
}
