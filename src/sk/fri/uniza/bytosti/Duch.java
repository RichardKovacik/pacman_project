package sk.fri.uniza.bytosti;

import sk.fri.uniza.Pozicia;

public class Duch extends Bytost {
    public Duch(Pozicia pozicia) {
        super(pozicia);
    }

    @Override
    public String getReprezentacia() {
        return "G";
    }

    @Override
    public void tik() {

        if (this.zivot <= 0) {
            System.out.println("Super poslal si dalsieho ducha na 3. svet (pretoze na druhom uz bol :) )");
        }
    }
}
