package sk.fri.uniza;

import sk.fri.uniza.bytosti.Bytost;
import sk.fri.uniza.bytosti.Duch;
import sk.fri.uniza.bytosti.PacMan;
import sk.fri.uniza.exceptions.NedovolPohnutException;

import java.util.ArrayList;
import java.util.Iterator;

public class Bludisko {
    public static final int SIRKA = 10;
    public static final int VYSKA = 5;
    private ArrayList<Bytost> bytosti;
    private String[][] mapa;

    public Bludisko() {
        this.mapa = new String[VYSKA][SIRKA];
        this.bytosti = new ArrayList<>();
        this.vytvorPrazdnu();
    }
    private void vytvorPrazdnu() {
        for (int i = 0; i < VYSKA; i++){
            for (int j = 0; j < SIRKA; j++){
                if (i == 0 || i == VYSKA -1){
                    mapa[i][j] = "#";
                }else if (j == 0 || j == SIRKA-1){
                    mapa[i][j] = "#";
                }else {
                    mapa[i][j] = " ";
                }
            }
        }

    }
    public String vratPlochuAsString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < VYSKA; i++){
            for (int j = 0; j < SIRKA; j++){
                builder.append(mapa[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    //pridaj bytost na danu poziciu
    public void pridajBytost(Bytost bytost) {
        if (bytost == null) {
            throw new IllegalStateException();
        }
        this.bytosti.add(bytost);
        this.mapa[bytost.getPozicia().getY()][bytost.getPozicia().getX()] = bytost.getReprezentacia();
    }
    //metoda posunie packamana a skotroluje na novej pozici ducha
    public void posunPackama(Smer smer){
        for (Bytost b : this.bytosti) {
            if (b instanceof  PacMan) {
                try {
                    ((PacMan) b).posunSa(smer);

                } catch (NedovolPohnutException e){
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
    public void tik(){
        this.vytvorPrazdnu();
        this.kotrolaKolizii();
        this.odstranMrtveBytosti();

        for (Bytost b : this.bytosti) {
            b.tik();
            if (b instanceof Duch){
                ((Duch) b).posunSaNahodne();

            }
            mapa[b.getPozicia().getY()][b.getPozicia().getX()] = b.getReprezentacia();
        }

    }

    //skotroluje ci packman nie je v konflikte s duchom
    private void kotrolaKolizii(){
        for (Bytost b : this.bytosti) {
            if (b instanceof  PacMan) {
                //skotroluj koliziu s duchmi
                for (Bytost b1: this.bytosti) {
                    if (b1 instanceof Duch){
                        ((PacMan) b).skonrolujDucha((Duch)b1);
                    }
                }
                return;
            }
        }
    }
    private void odstranMrtveBytosti(){
        Iterator<Bytost> bytostIterator = this.bytosti.iterator();

        while (bytostIterator.hasNext()){
            Bytost b = bytostIterator.next();
            
            if (b.getZivot() <= 0){
                b.tik();
                bytostIterator.remove();
            }
        }
    }


    public void print(String s) {
        System.out.println(s);
        //nech je to vidiet aj vizulane ze packamn bude na pozici kde bol predtym duch
    }
}
