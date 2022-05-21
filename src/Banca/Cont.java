package Banca;
import Card.*;
import java.util.*;

public abstract class Cont {
    private String IBAN, valuta;
    private Double sold_disponibil, sold_blocat;

    private Set<Card> carduri = new HashSet<Card>();
    // private List<Tranzactie> tranzactii = new ArrayList<Tranzactie>();

    // private final CardFactory cardFactory = new CardFactory();

    Cont(String valuta, Double sold_disponibil, Double sold_blocat, Double dobanda, Card card){
        Random rand = new Random();
        int int_random = rand.nextInt(10);
        int int_random2 = 10000+rand.nextInt(90000);
        int int_random3 = 10000+rand.nextInt(90000);
        int int_random4 = 10000+rand.nextInt(90000);
        int int_random5 = 10000+rand.nextInt(90000);

        this.IBAN = String.format("RO%s%s" + int_random + " BREL%s%s%s%s" + int_random2 + int_random3 + int_random4 + int_random5);
        this.valuta = valuta;
        this.sold_disponibil = sold_disponibil;
        this.sold_blocat = sold_blocat;
        this.carduri.add(card);
    }

    public abstract String extragere_suma(Integer suma);

    public String adauga_suma(Double Suma){
        this.setSold_disponibil(this.getSold_disponibil() + Suma);
        return String.format("Suma adaugata cu succes! Noul dumneavoastra sold disponibil este:%s" + this.getSold_disponibil());
    }

    public void adauga_card(Card c){
        try{
            if (!this.getCarduri().contains(c)) {
                Set<Card> carduri = this.getCarduri();
                carduri.add(c);
                this.setCarduri(carduri);
            }
            else throw new ArithmeticException("Acest card este deja adaugat!");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /*
    public void adauga_tranzactie(Tranzactie t){
        List<Tranzactie> tranzactii = this.getTranzactii();
        tranzactii.add(t);
        this.setTranzactii(tranzactii);
    }
    */

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public Double getSold_disponibil() {
        return sold_disponibil;
    }

    public void setSold_disponibil(Double sold_disponibil) {
        this.sold_disponibil = sold_disponibil;
    }

    public Double getSold_blocat() {
        return sold_blocat;
    }

    public void setSold_blocat(Double sold_blocat) {
        this.sold_blocat = sold_blocat;
    }

    public Set<Card> getCarduri() {
        return carduri;
    }

    public void setCarduri(Set<Card> carduri) {
        this.carduri = carduri;
    }

}
