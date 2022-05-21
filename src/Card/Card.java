package Card;

import java.text.SimpleDateFormat;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class Card {
    private final Integer id, CVV;
    private final String data_expirare;
    private String data_emitere;
    private String nume, prenume;
    private String numar_card;
    private Integer pin;
    private String valuta;
    private String IBAN;
    private Double comision = 0.0;
    private Boolean contactless;

    static private final Set<String> Numere = new HashSet<>();

    Card(Integer id, String IBAN, String nume, String prenume){
        this.id = id;
        this.IBAN = IBAN;
        this.nume = nume;
        this.prenume = prenume;

        // Generare data emitere si data expirare card
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        Date date = new Date(System.currentTimeMillis());;
        this.data_emitere = formatter.format(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR,4);
        this.data_expirare = formatter.format(c.getTime());

        // Generare numar card
        while(Numere.contains(this.numar_card))
            this.numar_card = this.generare_numar_card();
        Numere.add(this.numar_card);

        // Generate CVV
        this.CVV = this.generare_CVV();
    }

    private String generare_numar_card(){
        byte[] array = new byte[16];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    private int generare_CVV(){
        var rand = new Random();
        return 100 + rand.nextInt(899);
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

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getData_emitere() {
        return data_emitere;
    }

    public void setData_emitere(String data_emitere) {
        this.data_emitere = data_emitere;
    }

    public String getData_expirare() {
        return data_expirare;
    }

    public String getNumar_card() {
        return numar_card;
    }

    public void setNumar_card(String numar_card) {
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
        this.IBAN = IBAN;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }
}
