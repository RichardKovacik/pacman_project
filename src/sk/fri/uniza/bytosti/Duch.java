package sk.fri.uniza.bytosti;

import sk.fri.uniza.Pozicia;
import sk.fri.uniza.Smer;

public class Duch extends Bytost {
    public Duch(Pozicia pozicia) {
        super(pozicia);
    }
    //duch sa vzdy posunie kazdy tik hry
    public void posunSaNahodne(){
        Pozicia nova;
      //  do {
            Smer nahodny = Smer.dajNahodnySmer();
            nova = nahodny.vratNovuPoziciu(this.pozicia);
      //  } while (!this.jeSpravnaPozicia(nova));
        if (this.jeSpravnaPozicia(nova)) {
            this.setPozicia(nova);
        }

    }
    @Override
    public String getReprezentacia() {
        return "G";
    }

    public void tik(){
        if (this.zivot <= 0) {
            System.out.println("Super poslal si dalsieho ducha na 3. svet (pretoze na druhom uz bol :) )");
        }
    }
}
