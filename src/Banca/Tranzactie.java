package Banca;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tranzactie implements Comparable<Tranzactie> {
    private String data, detalii = "";
    private Integer suma_tranzactie;
    private Boolean decontare;

    Tranzactie(String data, String detalii, Integer suma_tranzactie, Boolean decontat){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        this.data = formatter.format(date);
        this.detalii = detalii;
        this.suma_tranzactie = suma_tranzactie;
        this.decontare = decontare;
    }

    @Override
    public int compareTo(Tranzactie t){
        return this.data.compareTo(t.getData());
    }

    public String get_tranzactie(){
        return "Data:" + this.getData() + "\n" + "Suma:" + String.valueOf(this.getSuma_tranzactie()) + "\n" + this.getDetalii();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public Integer getSuma_tranzactie() {
        return suma_tranzactie;
    }

    public void setSuma_tranzactie(Integer suma_tranzactie) {
        this.suma_tranzactie = suma_tranzactie;
    }

    public Boolean getDecontare() {
        return decontare;
    }

    public void setDecontare(Boolean decontare) {
        this.decontare = decontare;
    }
}
