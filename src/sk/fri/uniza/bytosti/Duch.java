package sk.fri.uniza.bytosti;

import sk.fri.uniza.Pozicia;
import sk.fri.uniza.Smer;
import sk.fri.uniza.exceptions.NedovolPohnutException;

public class Duch extends Bytost {
    public Duch(Pozicia pozicia) {
        super(pozicia);
    }
    public void posunSaNahodne() throws NedovolPohnutException {
        Smer nahodny = Smer.dajNahodnySmer();
        Pozicia nova = nahodny.vratNovuPoziciu(this.pozicia);
        //kotrola nove pozicie, ak je mimo pola vratim vynimku a nedovolim zmenit poziciu
        if (this.jeSpravnaPozicia(nova)){
            this.setPozicia(nova);
        }

    }
    @Override
    public String getReprezentacia() {
        return "G";
    }

    @Override
    public void tik(){
        if (this.zivot <= 0) {
            System.out.println("Super poslal si dalsieho ducha na 3. svet (pretoze na druhom uz bol :) )");
        }
    }
}
