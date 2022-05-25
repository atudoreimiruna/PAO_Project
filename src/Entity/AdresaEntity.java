package Entity;

public class AdresaEntity {
    protected Integer id_adresa;
    protected Integer cod_postal;
    protected String strada, oras, tara;
    private Integer ownerId_adresa;


    public AdresaEntity(Integer id_adresa, Integer ownerId_adresa)
    {
        this.id_adresa = id_adresa;
        this.ownerId_adresa = ownerId_adresa;
    }

    public AdresaEntity(Integer id_adresa){
        this.id_adresa = id_adresa;
     }

    public AdresaEntity()
    {

    }

    public AdresaEntity( Integer id_adresa, Integer cod_postal, String strada, String oras, String tara, Integer ownerId_adresa){
        this.id_adresa = id_adresa;
        this.cod_postal = cod_postal;
        this.strada = strada;
        this.oras = oras;
        this.tara = tara;
        this.ownerId_adresa = ownerId_adresa;
    }

    public Integer getId_adresa() {
        return id_adresa;
    }

    public void setId_adresa(Integer id_adresa) {
        this.id_adresa = id_adresa;
    }

    public Integer getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(Integer cod_postal) {
        this.cod_postal = cod_postal;
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

    public Integer getOwnerId_adresa() {
        return ownerId_adresa;
    }

    public void setOwnerId_adresa(Integer ownerId_adresa) {
        this.ownerId_adresa = ownerId_adresa;
    }
}
