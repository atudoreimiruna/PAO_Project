package Entity;

import Model.Card;

import java.util.ArrayList;
import java.util.List;

public class ContEntity {
        protected Integer id;
        protected String valuta, swift, nume;
        protected Integer sold_disponibil, sold_blocat;
        protected String type;
        // private Integer ownerId;
        private List<Card> cards = new ArrayList<>();

    public ContEntity( String nume, Integer id)
    {
        this.nume= nume;
        this.id = id;
        // this.ownerId = ownerId;
    }

    public ContEntity( Integer id, String nume, String swift, String valuta, Integer sold_disponibil, Integer sold_blocat, String type, List<Card> cards){
        this.swift = swift;
        this.nume= nume;
        this.valuta = valuta;
        this.sold_disponibil = sold_disponibil;
        this.sold_blocat = sold_blocat;
        this.type = type;
        this.id = id;
        this.cards = cards;
        // this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getSold_disponibil() {
        return sold_disponibil;
    }

    public void setSold_disponibil(Integer sold_disponibil) {
        this.sold_disponibil = sold_disponibil;
    }

    public Integer getSold_blocat() {
        return sold_blocat;
    }

    public void setSold_blocat(Integer sold_blocat) {
        this.sold_blocat = sold_blocat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
