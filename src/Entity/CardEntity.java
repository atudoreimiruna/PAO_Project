package Entity;

public class CardEntity {
    private Integer id, CVV ;
    private String data_expirare;
    private String data_emitere;
    private String nume, prenume;
    private String numar_card;
    private Integer pin;
    private String valuta;
    private String IBAN;
    private Double comision = 0.0;

    public CardEntity(Integer id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public CardEntity(Integer id, Integer CVV, String data_expirare, String data_emitere, String nume, String numar_card, Integer pin, String valuta, String prenume, String IBAN, double comision) {
        this.id = id;
        this.data_emitere = data_emitere;
        this.numar_card = numar_card;
        this.pin = pin;
        this.valuta = valuta;
        this.CVV = CVV;
        this.data_expirare = data_expirare;
        this.nume = nume;
        this.prenume = prenume;
        this.IBAN = IBAN;
        this.comision = comision;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCVV() {
        return CVV;
    }

    public String getData_expirare() {
        return data_expirare;
    }

    public String getData_emitere() {
        return data_emitere;
    }

    public void setData_emitere(String data_emitere) {
        this.data_emitere = data_emitere;
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

    public String getNumar_card() {
        return numar_card;
    }

    public void setNumar_card(String numar_card) {
        this.numar_card = numar_card;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
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

    @Override
    public String toString() {
        return "CardEntity{" +
                "id=" + id +
                ", CVV=" + CVV +
                ", data_expirare='" + data_expirare + '\'' +
                ", data_emitere='" + data_emitere + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", numar_card='" + numar_card + '\'' +
                ", pin=" + pin +
                ", valuta='" + valuta + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", comision=" + comision +
                '}';
    }
}
