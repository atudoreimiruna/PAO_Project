package Model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Card {
    private Integer id, CVV;
    private String data_expirare;
    private String data_emitere;
    private String numar_card;
    private Integer pin;
    private String valuta;
    private String IBAN;
    private double comision = 0.0;

    static private final Set<String> Numere = new HashSet<>();

    public Card(Integer id, Integer CVV, String data_expirare, String data_emitere, String numar_card, Integer pin, String valuta, String IBAN, double comision) {
        this.id = id;
        this.data_emitere = data_emitere;
        this.numar_card = numar_card;
        this.pin = pin;
        this.valuta = valuta;
        this.CVV = CVV;
        this.data_expirare = data_expirare;
        // this.nume = nume;
        // this.prenume = prenume;
        this.IBAN = IBAN;
        this.comision = comision;
    }

    public Card() {

    }

    public Card(Integer id, String IBAN){
        this.id = id;
        this.IBAN = IBAN;
    }

    public void setCVV(Integer CVV) {
        this.CVV = CVV;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCVV() {
        return CVV;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getData_emitere() {
        return data_emitere;
    }

    public void setData_emitere(String data_emitere) {
        this.data_emitere = data_emitere;
    }

    public void setData_expirare(String data_expirare) {
        this.data_expirare = data_expirare;
    }

    public String getData_expirare() {
        return data_expirare;
    }

    public String getNumar_card() {
        return numar_card;
    }

    public void setNumar_card(String numar_card) {
        Random rand = new Random();
        int int_random = 1000+rand.nextInt(9000);
        int int_random1 = 1000+rand.nextInt(9000);

        numar_card = String.format("RO " + int_random + " " + int_random1);
        this.numar_card = numar_card;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        Random rand = new Random();
        int int_random = rand.nextInt(100);
        int int_random2 = 1000+rand.nextInt(9000);
        int int_random3 = 1000+rand.nextInt(9000);
        int int_random4 = 1000+rand.nextInt(9000);
        int int_random5 = 1000+rand.nextInt(9000);

        IBAN = String.format("RO" + int_random + " BREL " + int_random2 + " " + int_random3 + " " + int_random4 + " " + int_random5);
        this.IBAN = IBAN;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }


    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", CVV=" + CVV +
                ", data_expirare='" + data_expirare + '\'' +
                ", data_emitere='" + data_emitere + '\'' +
                ", numar_card='" + numar_card + '\'' +
                ", pin=" + pin +
                ", valuta='" + valuta + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", comision=" + comision +
                '}';
    }
}
