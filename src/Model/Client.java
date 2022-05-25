package Model;

public class Client implements Comparable<Client> {
    private int id_client;
    private String nume, prenume;
    private String telefon;
    //private Adresa adresa;


    public Client(int id_client, String nume, String prenume, String telefon) {
        this.id_client = id_client;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        // this.email = email;
        //this.adresa = adresa;
    }

    public Client()
    {

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

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                // ", adresa=" + adresa +
                '}';
    }
}
