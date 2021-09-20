package sk.fri.uniza.bytosti;

import sk.fri.uniza.Pozicia;
import sk.fri.uniza.Smer;
import sk.fri.uniza.exceptions.MimoPlochyExsception;
import sk.fri.uniza.exceptions.NezijeException;

public class PacMan extends Bytost {

    public PacMan(Pozicia pozicia) {
        super(pozicia);
    }

    //metoda skontroluje koliziu s duchom
    public boolean jeKoliziaSDuchom(Duch duch) {

        if (this.getPozicia().getX() == duch.getPozicia().getX() &&
            this.getPozicia().getY() == duch.getPozicia().getY()) {
            this.zivot --;
            return true;
        }

        return false;
    }
    public void zmenPoziciu(Smer smer) throws MimoPlochyExsception {
        Pozicia novaPos = new Pozicia(this.getPozicia().getX(), this.getPozicia().getY());

        switch (smer) {
            case UP -> novaPos.setY(novaPos.getY() + 1);
            case DOWN -> novaPos.setY(novaPos.getY() - 1);
            case LEFT -> novaPos.setX(novaPos.getX() - 1);
            case RIGHT -> novaPos.setX(novaPos.getX() + 1);
        }
        this.skontrolujNovuPozicu(novaPos);
        this.setPozicia(novaPos);
    }

    @Override
    public String getReprezentacia() {
        return "P";
    }

    @Override
    public void tik() throws NezijeException {
        if (this.zivot <= 0){
            throw new NezijeException("Packama zabil duch :(");
        }

    }
}
