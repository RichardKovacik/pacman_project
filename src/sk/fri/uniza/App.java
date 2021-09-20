package sk.fri.uniza;

import sk.fri.uniza.bytosti.Duch;
import sk.fri.uniza.bytosti.PacMan;
import sk.fri.uniza.exceptions.NedovolPohnutException;
import sk.fri.uniza.exceptions.NezijeException;

public class App {

    public static void main(String[] args) {
	// write your code here
        Bludisko bludisko = new Bludisko();

        PacMan pacMan = new PacMan(new Pozicia(1, 1));
        Duch duch = new Duch(new Pozicia(2, 1));

        bludisko.pridajBytost(pacMan);
        bludisko.pridajBytost(duch);

        bludisko.print(bludisko.vratPlochuAsString());

        try {
            bludisko.posunPackama(Smer.RIGHT);
            bludisko.tik();
            bludisko.print(bludisko.vratPlochuAsString());

        }catch (NezijeException | NedovolPohnutException e) {
            System.out.println(e.getMessage());
        }


    }
}
