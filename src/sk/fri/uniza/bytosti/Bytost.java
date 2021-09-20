package sk.fri.uniza.bytosti;

import sk.fri.uniza.HraciaPlocha;
import sk.fri.uniza.Pozicia;
import sk.fri.uniza.exceptions.MimoPlochyExsception;

public abstract class Bytost implements IZomritelny {
    private Pozicia pozicia;
    protected int zivot;
    private String reprezentacia;

    public Bytost(Pozicia pozicia) {
        this.pozicia = pozicia;
        this.zivot = 3;
    }

    public void skontrolujNovuPozicu(Pozicia pozicia) throws MimoPlochyExsception{
        if (pozicia.getX() < 0 || pozicia.getX() >= HraciaPlocha.SIRKA &&
                pozicia.getY() < 0 || pozicia.getY() >= HraciaPlocha.VYSKA) {
            throw new MimoPlochyExsception();
        }
    }

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
