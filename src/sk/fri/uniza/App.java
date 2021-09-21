package sk.fri.uniza;

import sk.fri.uniza.bytosti.Duch;
import sk.fri.uniza.bytosti.PacMan;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
	// write your code here
        Bludisko bludisko = new Bludisko();

        PacMan pacMan = new PacMan(new Pozicia(1, 1));
        Duch duch = new Duch(new Pozicia(2, 1));
        Duch duch1 = new Duch(new Pozicia(4, 3));

        bludisko.pridajBytost(pacMan);
        bludisko.pridajBytost(duch);
        bludisko.pridajBytost(duch1);

        bludisko.print(bludisko.vratPlochuAsString());

        Scanner citac = new Scanner(System.in);
        char volba;

        while (true) {
            System.out.println("zadaj smer:");
            volba = citac.next().charAt(0);

            switch (volba) {
                case 'u' -> bludisko.posunPackama(Smer.UP);
                case 'd' -> bludisko.posunPackama(Smer.DOWN);
                case 'l' -> bludisko.posunPackama(Smer.LEFT);
                case 'r' -> bludisko.posunPackama(Smer.RIGHT);
                case 'k' -> System.exit(0);
                default -> System.out.println("Zadal si zly smer");
            }
            bludisko.tik();
            bludisko.print(bludisko.vratPlochuAsString());
        }

    }
}
