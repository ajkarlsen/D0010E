package labb3.modell;

import java.util.ArrayList;
import java.util.Observable;
import labb3.verktyg.Punkt;

public class Nivå extends Observable {


	private ArrayList<Rum> roomList;
	private Rum userRoom;


	public Nivå(Rum startrum, ArrayList<Rum> rum) {
		this.userRoom = startrum;
		this.roomList = rum;



		if (!roomList.contains(startrum)) {
			throw new RuntimeException("Startrum inte med");
		}



		for (int i = 0; i < rum.size(); i++) { // Loopar genom alla rum i listan och kollar att inget överlappar
			Rum r1 = rum.get(i);
			Punkt p1 = r1.getPunkt();

			for (int j = i + 1; j < rum.size(); j++) {
				Rum r2 = rum.get(j);
				Punkt p2 = r2.getPunkt();

				if (p1.x() < p2.x() + r2.getBredd() &&
						p1.x() + r1.getBredd() > p2.x() &&
						p1.y() < p2.y() + r2.getHöjd() &&
						p1.y() + r1.getHöjd() > p2.y()) {

					throw new RuntimeException("Rummen överlappar: " + r1 + " och " + r2);
				}
			}

		}
	}



	public ArrayList<Rum> getAllRoom() { // Returnerar arraylist med alla rum
		return roomList;
	}


	public Rum getRoom() { // Returnerar rummet användaren är i
		return userRoom;
	}


	// TODO: Skriv klar instansmetoden hoppaÅt nedan så att den ändrar det rum
	// som användaren "är i" om det är möjligt genom att följa en gång från
	// rummet och i riktning väderstreck.
	//
	// Om väderstreck inte är en riktning i vilken det finns en gång, så ändras
	// inte rummet användaren "är i" (och inte heller kastas undantag). (Denna
	// metod använder kontrolldelen av programmet för att begära ett hopp till
	// angränsande rum efter att användaren tryckt på en tangent.)

	public void hoppaÅt(Väderstreck väderstreck) {
		if (this.userRoom.finnsUtgångÅt(väderstreck)) { // Kollar att utgång finns sen hoppar genom att byta användarens rum

			userRoom =  this.userRoom.gångenÅt(väderstreck).getTill();
			System.out.println("Du har hoppat till ett nytt rum.");

		} else {
			System.out.println("Det finns ingen utgång åt den riktningen.");
		}
		setChanged();
		notifyObservers();
	}
}
