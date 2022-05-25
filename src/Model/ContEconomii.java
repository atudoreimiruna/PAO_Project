package Model;

public class ContEconomii extends Cont {
    private Integer limita = 10000000;
    Integer valoare_minima = 500;

    ContEconomii(Integer valoare_minima, Integer limita){
        super();
        this.setType("Economies");
        this.valoare_minima = valoare_minima;
        this.limita = limita;
    }

    public String adaugare_bani(Integer Suma) {
        String s = null;
        if (Suma < this.valoare_minima) {
            s = String.format("Poti adauga o valoare de minim " + this.valoare_minima + " " + this.getValuta() + " in acest cont.");
            return s;
        }
        if (Suma > this.getLimita() || (Suma + this.getSold_disponibil() > this.getLimita())) {
            s = String.format("Aceasta valoare este peste limita contului " + this.getLimita() + " " + this.getValuta());
            return s;
        }
        this.setSold_disponibil(this.getSold_disponibil() + Suma); {
            s = String.format("Banii au fost adaugati cu succes! Noul sold este: " + (this.getSold_disponibil() + Suma) + " " + this.getValuta());
            return s;
        }
    }

    @Override
    public String toString() {
        return "ContEconomii{" +
                "swift='" + swift + '\'' +
                ", limita=" + limita +
                ", id=" + id +
                ", valoare_minima=" + valoare_minima +
                ", sold_disponibil=" + sold_disponibil +
                ", type=" + type +
                ", solt_blocat=" + sold_blocat +
                ", valuta=" + valuta +
                '}';
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