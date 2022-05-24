package Entity;

public class TranzactieEntity {
    private Integer id_tranzactie;
    private String data, detalii = "";
    private String fromIBAN, toIBAN;
    private Integer suma_tranzactie;

    public TranzactieEntity(Integer id_tranzactie, String data, String fromIBAN, String toIBAN, String detalii, Integer suma_tranzactie){
        this.id_tranzactie = id_tranzactie;
        this.data = data;
        this.fromIBAN = fromIBAN;
        this.toIBAN = toIBAN;
        this.detalii = detalii;
        this.suma_tranzactie = suma_tranzactie;
    }

    public TranzactieEntity(Integer id_tranzactie)
    {
        this.id_tranzactie = id_tranzactie;
    }

    @Override
    public String toString() {
        return "TranzactieEntity{" +
                "id_tranzactie=" + id_tranzactie +
                ", data='" + data + '\'' +
                ", detalii='" + detalii + '\'' +
                ", fromIBAN='" + fromIBAN + '\'' +
                ", toIBAN='" + toIBAN + '\'' +
                ", suma_tranzactie=" + suma_tranzactie +
                '}';
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

    public Integer getId_tranzactie() {
        return id_tranzactie;
    }

    public void setId_tranzactie(Integer id_tranzactie) {
        this.id_tranzactie = id_tranzactie;
    }

    public String getFromIBAN() {
        return fromIBAN;
    }

    public void setFromIBAN(String fromIBAN) {
        this.fromIBAN = fromIBAN;
    }

    public String getToIBAN() {
        return toIBAN;
    }

    public void setToIBAN(String toIBAN) {
        this.toIBAN = toIBAN;
    }

    public Integer getSuma_tranzactie() {
        return suma_tranzactie;
    }

    public void setSuma_tranzactie(Integer suma_tranzactie) {
        this.suma_tranzactie = suma_tranzactie;
    }
}
