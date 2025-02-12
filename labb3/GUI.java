package labb3;

import java.util.Observable;

import labb3.modell.Nivå;
import labb3.vy.Målarduk;

// TODO: Klassen ska ärva klassen JFrame i standardbibliotekets paket 
// javax.swing och implementera gränssnittet Observer i paketet java.util. 
public class GUI {

	private Målarduk målarduk;

	public GUI(Nivå enNivå) {

		// TODO: Anropa metoden setDefaultCloseOperation med konstanten
		// JFrame.EXIT_ON_CLOSE.

		// TODO: Gör så att enNivå observerar this (instansen av GUI som denna
		// kod håller på att skapa.

		// TODO: Tilldela tillståndsvariabeln målarduk en instans av klassen
		// Målarduk.

		// TODO: Använd setPreferredSize på målarduk och sätt dess dimensioner
		// så alla rum faktiskt syns. Ett tips är att loopa igenom nivåns alla
		// rum och räkna ut vilken bredd och höjd målarduken måste ha(!)
		// Annars går det också att dra till med en storlek och sen bara
		// använda rum som säkert kan visas på målarduken.

		// TODO: Lägg till en KeyListener på målardiken, dvs en instans av
		// typen Tangentbordslyssnare. Notera att lyssnaren vill ha enNivå
		// som argument till konstruktorn för att kunna påverka just den
		// nivån.

		// TODO: Anropa setContentPane med målarduk, så att målarduk är
		// den yta som vår JFrame kommer att ha. Sen återstår bara att
		// göra setVisible(true) och pack().
	}

	// TODO: Metoden update ska vara den i gränssnittet Observer. Lägg därför
	// till @Override på raden innan metodhuvudet. (Klassen måste sen importera
	// java.util.Observer.)
	public void update(Observable o, Object arg) {
		// Detta anrop triggar ett anrop till paintComponent i Målarduk.
		// Avkommentera raden (när Målarduk "är-en" JPanel). 
		// this.målarduk.repaint();
	}
}
