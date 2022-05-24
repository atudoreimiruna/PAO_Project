package Model;

public class Adresa {
    private Integer id_adresa;
    private String strada, oras, tara;
    private Integer cod_postal;

    public Adresa(Integer id_adresa, String strada, String oras, String tara, Integer cod_postal) {
        this.id_adresa = id_adresa;
        this.strada = strada;
        this.oras = oras;
        this.tara = tara;
        this.cod_postal = cod_postal;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "id_adresa=" + id_adresa +
                ", strada='" + strada + '\'' +
                ", oras='" + oras + '\'' +
                ", tara='" + tara + '\'' +
                ", cod_postal=" + cod_postal +
                '}';
    }

    public Integer getId_adresa() {
        return id_adresa;
    }

    public void setId_adresa(Integer id_adresa) {
        this.id_adresa = id_adresa;
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
