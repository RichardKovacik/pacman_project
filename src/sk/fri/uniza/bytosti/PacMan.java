package sk.fri.uniza.bytosti;

import sk.fri.uniza.Pozicia;
import sk.fri.uniza.Smer;
import sk.fri.uniza.exceptions.NedovolPohnutException;

public class PacMan extends Bytost {

    public PacMan(Pozicia pozicia) {
        super(pozicia);
    }

    //metoda skontroluje koliziu s duchom
    public void skonrolujDucha(Duch duch) {

        if (this.getPozicia().getX() == duch.getPozicia().getX() &&
            this.getPozicia().getY() == duch.getPozicia().getY()) {
            System.out.println("kolizia");
            duch.zivot = 0;
        }
    }

    public void posunSa(Smer smer) throws NedovolPohnutException {
        Pozicia nova = smer.vratNovuPoziciu(this.pozicia);

        if (this.jeSpravnaPozicia(nova)){
            this.setPozicia(nova);
        }else {
            throw new NedovolPohnutException();
        }

    }

    @Override
    public String getReprezentacia() {
        return "P";
    }


    @Override
    public void tik() {
        if (this.zivot <= 0){
            System.out.println("Prehral sii hru");
        }

    }
}
