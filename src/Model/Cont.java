package Model;
import java.util.*;

public class Cont {
    protected Integer id;
    protected String valuta, swift;
    protected Integer sold_disponibil, sold_blocat;
    protected String type;
    private List<Card> cards = new ArrayList<>();


    public Cont(Integer id, String swift, String valuta, Integer sold_disponibil, Integer sold_blocat, String type){
        this.id = id;
        this.swift = swift;
        this.valuta = valuta;
        this.sold_disponibil = sold_disponibil;
        this.sold_blocat = sold_blocat;
        this.type = type;
    }

    public Cont()
    {

    }
    public Cont( Integer id) {
        this.swift = this.generare_Swift();
        this.sold_disponibil = 0;
        this.id = id;
    }

    public String adauga_suma(Integer Suma){
        this.setSold_disponibil(this.getSold_disponibil() + Suma);
        return String.format("Suma adaugata cu succes! Noul dumneavoastra sold disponibil este: " + this.getSold_disponibil());
    }

    public void adauga_card(Card c){
        try{
            if (!this.getCarduri().contains(c)) {
                List<Card> carduri = this.getCarduri();
                carduri.add(c);
                this.setCarduri(carduri);
            }
            else throw new ArithmeticException("Acest card este deja adaugat!");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private String generare_Swift(){
        Random rand = new Random();
        int int_random = 10000+rand.nextInt(90000);

        String bank = "BRD";
        String swift = String.format("BRD" + int_random);
        return swift;
    }

    @Override
    public String toString() {
        return "Cont{" +
                "valuta='" + valuta + '\'' +
                ", swift='" + swift + '\'' +
                ", sold_disponibil=" + sold_disponibil +
                ", sold_blocat=" + sold_blocat +
                ", type='" + type + '\'' +
                '}';
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public Integer getSold_disponibil() {
        return sold_disponibil;
    }

    public void setSold_disponibil(Integer sold_disponibil) {
        this.sold_disponibil = sold_disponibil;
    }

    public Integer getSold_blocat() {
        return sold_blocat;
    }

    public void setSold_blocat(Integer sold_blocat) {
        this.sold_blocat = sold_blocat;
    }

    public List<Card> getCarduri() {
        return cards;
    }

    public void setCarduri(List<Card> carduri) {
        this.cards = carduri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
