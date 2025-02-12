package labb3;

import java.awt.Color;

/**
 * @author Håkan Jonsson
 */
abstract public class GlobalaKonstanter {

	// Konstanter som bestämmer hur rumsväggar ska vara:
	public static final int VÄGGTJOCKLEK = 8;
	public static final int HALV_VÄGGTJOCKLEK = VÄGGTJOCKLEK / 2;
	public static final int DUBBEL_VÄGGTJOCKLEK = VÄGGTJOCKLEK * 2;
	public static final Color VÄGGFÄRG = Color.BLACK;

	// Färgen på de gångar som förbinder rum:
	public static final Color GÅNGFÄRG = new Color(123, 63, 0);

	// Färgen på den "mark" som det inte finns rum eller gångar på:
	public static final Color MARKFÄRG = Color.WHITE;

	// Färg och storlek på den markering som anger vilket
	// rum användaren "är i":
	public static final Color ANVÄNDARFÄRG = Color.BLACK;
	public static final int ANVÄNDARRADIE = HALV_VÄGGTJOCKLEK;

	// Varje rum har en array med utgående gångar som är så här lång:
	public static final int ANTAL_VÄDERSTRECK = 4;
}
