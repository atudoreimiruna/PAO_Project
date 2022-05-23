package Model;

public class Client implements Comparable<Client> {
    private final int id_client;
    private String nume, prenume;
    private String email, telefon;
    //private Adresa adresa;

    public Client(int id_client, String nume, String prenume, String email, String telefon) {
        this.id_client = id_client;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        //this.adresa = adresa;
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

    public void setEmail(String email) throws Exception {
        if (!email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[A-Za-z]{3}$")) {
            throw new Exception("Email invalid");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) throws Exception {
        if (!telefon.matches("^\\d{10}$")) {
            throw new Exception("Telefon invalid");
        }
        this.telefon = telefon;
    }

    @Override
    public int compareTo(Client c) {
        return Integer.compare(this.id_client, c.id_client);
    }

    // public Adresa getAdresa() {
    //     return adresa;
    // }

    //public void setAdresa(Adresa adresa) {
    //    this.adresa = adresa;
    // }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                // ", adresa=" + adresa +
                '}';
    }
}
