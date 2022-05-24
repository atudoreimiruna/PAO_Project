package Model;
import java.util.*;

public class Cont {
    protected Integer id;
    protected String valuta, swift, nume;
    protected Integer sold_disponibil, sold_blocat;
    protected String type;
    private List<Card> cards = new ArrayList<>();


    // public abstract String extragere_suma(Integer suma);

    // private List<Tranzactie> tranzactii = new ArrayList<Tranzactie>();

    // private final CardFactory cardFactory = new CardFactory();

    public Cont( String nume, String swift, String valuta, Integer sold_disponibil, Integer sold_blocat, String type){
        this.swift = swift;
        this.nume= nume;
        this.valuta = valuta;
        this.sold_disponibil = sold_disponibil;
        this.sold_blocat = sold_blocat;
        this.type = type;
    }

    public Cont()
    {

    }
    public Cont(String nume, Integer id) {
        this.nume = nume;
        // this.IBAN = this.generare_IBAN(id);
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

    /*
    private String generare_IBAN(int id){
        Random rand = new Random();
        int int_random = rand.nextInt(100);
        int int_random2 = 1000+rand.nextInt(9000);
        int int_random3 = 1000+rand.nextInt(9000);
        int int_random4 = 1000+rand.nextInt(9000);
        int int_random5 = 1000+rand.nextInt(9000);

        String iban = String.format("RO" + int_random + " BREL " + int_random2 + " " + int_random3 + " " + int_random4 + " " + int_random5);
        return iban;
    }
    */
    private String generare_Swift(){
        Random rand = new Random();
        int int_random = 10000+rand.nextInt(90000);

        String bank = "BRD";
        String swift = String.format("BRD" + int_random);
        return swift;
    }

    // public List<Tranzactie> filtrare_tranzactii(List<Tranzactie> allTransactions){
    //     List<Tranzactie> tranzactii = new ArrayList<>();
    //     for(var tranzactie: allTransactions)
    //         if(tranzactie.getFromIBAN().equals(this.id))
    //             tranzactii.add(tranzactie);
    //     return tranzactii;
    // }

    // public int compare(Tranzactie tranzactie1, Tranzactie tranzactie2){
    //     return tranzactie1.getData().compareTo(tranzactie2.getData());
    // }

    /*
    public void adauga_tranzactie(Tranzactie t){
        List<Tranzactie> tranzactii = this.getTranzactii();
        tranzactii.add(t);
        this.setTranzactii(tranzactii);
    }
    */

    @Override
    public String toString() {
        return "Cont{" +
                "valuta='" + valuta + '\'' +
                ", swift='" + swift + '\'' +
                ", nume='" + nume + '\'' +
                ", sold_disponibil=" + sold_disponibil +
                ", sold_blocat=" + sold_blocat +
                ", type='" + type + '\'' +
                ", cards=" + cards +
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
