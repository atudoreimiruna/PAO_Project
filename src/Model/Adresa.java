package Model;

public class Adresa {
    private String strada, oras, tara;
    private Integer cod_postal;

    public Adresa(String strada, String oras, String tara, int cos_postal) {
        this.strada = strada;
        this.oras = oras;
        this.tara = tara;
        this.cod_postal = cos_postal;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "strada='" + strada + '\'' +
                ", oras='" + oras + '\'' +
                ", tara='" + tara + '\'' +
                ", cod_postal=" + cod_postal +
                '}';
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public Integer getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(Integer cod_postal) {
        this.cod_postal = cod_postal;
    }
}
