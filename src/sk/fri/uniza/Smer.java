package sk.fri.uniza;

import java.util.Random;

public enum Smer {
    LEFT("L"),
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

    public Pozicia vratNovuPoziciu(Pozicia stara) {
        Pozicia novaPos = new Pozicia(stara.getX(), stara.getY());

        switch (this) {
            case UP -> novaPos.setY(novaPos.getY() + 1);
            case DOWN -> novaPos.setY(novaPos.getY() - 1);
            case LEFT -> novaPos.setX(novaPos.getX() - 1);
            case RIGHT -> novaPos.setX(novaPos.getX() + 1);
        }

        return novaPos;
    }
   public static Smer dajNahodnySmer() {
        Smer[] smery = Smer.values();
        Random random = new Random();
        return smery[random.nextInt(4)];
   }
}
