package sk.fri.uniza.bytosti;

import sk.fri.uniza.Bludisko;
import sk.fri.uniza.Pozicia;

public abstract class Bytost {
    protected Pozicia pozicia;
    protected int zivot;
    private String reprezentacia;

    public Bytost(Pozicia pozicia) {
        this.pozicia = pozicia;
        this.zivot = 3;
    }

    public boolean jeSpravnaPozicia(Pozicia pozicia) {
        if ((pozicia.getX() <= 0 || pozicia.getX() >= Bludisko.SIRKA-1) ||
                (pozicia.getY() <= 0 || pozicia.getY() >= Bludisko.VYSKA -1)) {
            return false;
        }
        return true;
    }
    public abstract void tik();

    public Pozicia getPozicia() {
        return pozicia;
    }

    public void setPozicia(Pozicia pozicia) {
        this.pozicia = pozicia;
    }

    public int getZivot() {
        return zivot;
    }

    public void setZivot(int zivot) {
        this.zivot = zivot;
    }

    public String getReprezentacia() {
        return reprezentacia;
    }

    public void setReprezentacia(String reprezentacia) {
        this.reprezentacia = reprezentacia;
    }
}
