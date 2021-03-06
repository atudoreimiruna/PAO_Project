package Entity;

import Model.Adresa;
import Model.Cont;

import java.util.ArrayList;
import java.util.List;

public class ClientEntity {

    private int id_client;
    private String nume, prenume;
    private String telefon;
    private List<Cont> conts = new ArrayList<>();
    private List<Adresa> adrese = new ArrayList<>();


    public ClientEntity(int id_client, String nume, String prenume,  String telefon) {
        this.id_client = id_client;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
    }

    public ClientEntity()
    {

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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<Cont> getConts() {
        return conts;
    }

    public void setConts(List<Cont> conts) {
        this.conts = conts;
    }

    public List<Adresa> getAdrese() {
        return adrese;
    }

    public void setAdrese(List<Adresa> adrese) {
        this.adrese = adrese;
    }
}
