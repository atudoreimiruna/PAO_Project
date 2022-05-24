package Entity;

import Model.Cont;

import java.util.ArrayList;
import java.util.List;

public class ClientEntity {

    private final int id_client;
    private String nume, prenume;
    private String telefon;
    // private Adresa adresa;
    private List<Cont> conts = new ArrayList<>();


    public ClientEntity(int id_client, String nume, String prenume,  String telefon) {
        this.id_client = id_client;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        // this.email = email;
        // this.adresa = adresa;
    }

    public ClientEntity(int id_client, String nume)
    {
        this.id_client = id_client;
        this.nume = nume;
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

    // public String getEmail() {
    //    return email;
    //}

   // public void setEmail(String email) {
    //    this.email = email;
    //}

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
