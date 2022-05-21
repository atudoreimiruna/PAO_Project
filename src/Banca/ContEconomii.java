package Banca;

public class ContEconomii extends Cont{
    private Integer limita = 10000000;
    Integer valoare_minima = 500;

    ContEconomii(String valuta, Double sold_disponibil, Double sold_blocat, Integer valoare_minima){
        super(valuta, sold_disponibil, sold_blocat);
        this.setType("Economies");
        this.valoare_minima = valoare_minima;
    }


    @Override
    public String extragere_suma(Integer suma) {
        return "Poti extrage bani doar daca efectuezi o cerere!";
    }

    public String adaugare_bani(Double Suma){
        if(Suma < this.valoare_minima)
            return String.format("Poti adauga o valoare de minim %s" + this.valoare_minima + " %s" + this.getValuta() + " in acest cont.");
        if(Suma > this.getLimita() || (Suma + this.getSold_disponibil() > this.getLimita()))
            return String.format("Aceasta valoare este peste limita contului %s" + this.getLimita() + " %s" + this.getValuta());
        this.setSold_disponibil(this.getSold_disponibil()+Suma);
        return String.format("Banii au fost adaugati cu succes! Noul sold este: %s" + (this.getSold_disponibil() + Suma) + " %s" + this.getValuta());
    }

    public Integer getLimita() {
        return limita;
    }

    public void setLimita(Integer limita) {
        this.limita = limita;
    }

    public Integer getValoare_minima() {
        return valoare_minima;
    }

    public void setValoare_minima(Integer valoare_minima) {
        this.valoare_minima = valoare_minima;
    }
}
