package Banca;

public class ContCurent extends Cont{

    ContCurent(String valuta, Double sold_disponibil, Double sold_blocat){
        super(valuta, sold_disponibil, sold_blocat);
        this.setType("Standard");
    }

    @Override
    public String extragere_suma(Integer suma) {
        return "Poti extrage bani doar daca efectuezi o cerere!";
    }
}
