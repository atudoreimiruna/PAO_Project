package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Tranzactie {
    private String data, detalii = "";
    final private String fromIBAN, toIBAN;
    private Integer suma_tranzactie;
    List<Integer> tranzactii;

    Tranzactie(String data, String fromIBAN, String toIBAN, String detalii, Integer suma_tranzactie){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        this.fromIBAN = fromIBAN;
        this.toIBAN = toIBAN;
        this.data = formatter.format(date);
        this.detalii = detalii;
        this.suma_tranzactie = suma_tranzactie;
    }

    public String get_tranzactie(){
        return "Data:" + this.getData() + "\n" + "Suma:" + String.valueOf(this.getSuma_tranzactie()) + "\n" + this.getDetalii();
    }

    public String getFromIBAN() {
        return fromIBAN;
    }

    public String getToIBAN() {
        return toIBAN;
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

}
