package Model;

public class CardCumparaturi extends Card {
    protected
    Integer dobanda;
    Integer suma_minima_plata;
    Integer suma_maxima_adaugare;

    CardCumparaturi(Integer dobanda, Integer suma_maxima_adaugare, Integer suma_minima_plata){
        super();
        this.dobanda = dobanda;
        this.suma_maxima_adaugare =suma_maxima_adaugare;
        this.suma_minima_plata = suma_minima_plata;
    }

    public Integer getDobanda() {
        return dobanda;
    }

    public void setDobanda(Integer dobanda) {
        this.dobanda = dobanda;
    }

    public Integer getSuma_minima_plata() {
        return suma_minima_plata;
    }

    public void setSuma_minima_plata(Integer suma_minima_plata) {
        this.suma_minima_plata = suma_minima_plata;
    }

    public Integer getSuma_maxima_adaugare() {
        return suma_maxima_adaugare;
    }

    public void setSuma_maxima_adaugare(Integer suma_maxima_adaugare) {
        this.suma_maxima_adaugare = suma_maxima_adaugare;
    }
}
