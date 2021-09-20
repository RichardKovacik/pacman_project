package sk.fri.uniza;

import java.util.Random;

public enum Smer {
    LEFT("l"),
    RIGHT("R"),
    UP("U"),
    DOWN("D");

    private String repre;

    Smer(String repre) {
        this.repre = repre;
    }

    public String getRepre() {
        return repre;
    }
   public Smer dajNahodnySmer() {
        Smer smery[] = Smer.values();
        Random random = new Random();
        return smery[random.nextInt(4)];
   }
}
