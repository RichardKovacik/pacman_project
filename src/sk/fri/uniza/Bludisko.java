package sk.fri.uniza;

import sk.fri.uniza.bytosti.Bytost;
import sk.fri.uniza.bytosti.Duch;
import sk.fri.uniza.bytosti.PacMan;
import sk.fri.uniza.exceptions.NedovolPohnutException;
import sk.fri.uniza.exceptions.NezijeException;

import java.util.ArrayList;

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
        this.bytosti.add(bytost);
        this.mapa[bytost.getPozicia().getY()][bytost.getPozicia().getX()] = bytost.getReprezentacia();
    }
    public void posunPackama(Smer smer) throws NedovolPohnutException {
        for (Bytost b : this.bytosti) {
            if (b instanceof  PacMan) {
                ((PacMan) b).posunSa(smer);
                return;
            }
        }
    }
    public void tik() throws NezijeException, NedovolPohnutException {
        //update game state, positions etc.
        this.vytvorPrazdnu();
        this.kotrolaKolizii();

        for (Bytost b : this.bytosti) {
            b.tik();
            if (b instanceof Duch){
                ((Duch) b).posunSaNahodne();
            }
            mapa[b.getPozicia().getY()][b.getPozicia().getX()] = b.getReprezentacia();
        }

    }
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


    public void print(String s) {
        System.out.println(s);
        //nech je to vidiet aj vizulane ze packamn bude na pozici kde bol predtym duch
    }
}
