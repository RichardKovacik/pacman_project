package sk.fri.uniza.bytosti;

import sk.fri.uniza.Pozicia;
import sk.fri.uniza.Smer;
import sk.fri.uniza.exceptions.NedovolPohnutException;
import sk.fri.uniza.exceptions.NezijeException;

public class PacMan extends Bytost {

    public PacMan(Pozicia pozicia) {
        super(pozicia);
    }

    //metoda skontroluje koliziu s duchom
    public void skonrolujDucha(Duch duch) {

        if (this.getPozicia().getX() == duch.getPozicia().getX() &&
            this.getPozicia().getY() == duch.getPozicia().getY()) {
            duch.zivot = 0;
        }
    }

    public void posunSa(Smer smer) throws NedovolPohnutException {
        Pozicia nova = smer.vratNovuPoziciu(this.pozicia);
//        //skotrolujem ci mi nevyhodi vynimku
//        this.skontrolujNovuPozicu(this, nova);
//        //ak je vsetko v poriadku nastavim novu poziciu
//        this.setPozicia(nova);

        if (this.jeSpravnaPozicia(nova)){
            this.setPozicia(nova);
        }

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
