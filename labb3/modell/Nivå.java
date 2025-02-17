package labb3.modell;

import java.util.ArrayList;
import java.util.Observable;

// TODO: Gör så att klassen Nivå ärver Observable i paketet java.util. 
public class Nivå extends Observable {

	// TODO: Lägg till tillståndsvariabler för att hålla reda på nivåns rum och
	// i vilket rum som användaren "är".
	private ArrayList<Rum> levelRoom;
	private Rum userRoom;


	public Nivå(Rum startrum, ArrayList<Rum> rum) {
		// TODO: Kopiera in startrum och rum in i tillståndsvariablerna.
		this.userRoom = startrum;
		this.levelRoom = rum;

		// TODO: Kontrollera att startrum finns med i rum. Om inte, kasta
		// undantag med lämpligt felmeddelande.

		if (!levelRoom.contains(startrum)) {
			throw new RuntimeException("Inget rum boss");
		}

		// TODO: Kontrollera att inga rum överlappar varandra. Om det ändå är
		// fallet, kasta undantag med lämpligt felmeddelande.



	}

	// TODO: Skriv en instansmetod som returnerar alla rummen. Denna behöver
	// Målarduk för att veta vilka rum som finns på nivån och som ska ritas ut.


	public ArrayList<Rum> getAllRoom() {
		return levelRoom;
	}

	// TODO Skriv en instansmetod som returnerar en referens till det rum som
	// användaren "är i".

	public Rum getRoom() {
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
		if (this.userRoom.finnsUtgångÅt(väderstreck)) {
			Gång gång = this.userRoom.gångenÅt(väderstreck);
			Rum nyttRum = gång.getTill();

			// Kontrollera att det inte är samma rum
			if (nyttRum != this.userRoom) {
				userRoom = nyttRum;
				System.out.println("Du har hoppat till ett nytt rum.");
			} else {
				System.out.println("Du kan inte hoppa åt den riktningen, du är redan där.");
			}
		} else {
			System.out.println("Det finns ingen utgång åt den riktningen.");
		}
		setChanged();
		notifyObservers();
	}
}
