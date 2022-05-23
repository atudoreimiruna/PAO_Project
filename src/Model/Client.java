package Model;

public class Client {
    private final int id_client;
    private String nume, prenume, CNP;
    private String email, telefon;
    private Adresa adresa;

    public Client(int id_client, String nume, String prenume, String email, String telefon, Adresa adresa) {
        this.id_client = id_client;
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    public int getId_client() {
        return id_client;
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

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }
}
