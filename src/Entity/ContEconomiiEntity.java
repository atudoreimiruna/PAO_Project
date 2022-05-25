package Entity;

public class ContEconomiiEntity extends ContEntity {
    private Integer limita = 10000000;
    Integer valoare_minima = 500;

    public ContEconomiiEntity(Integer valoare_minima, Integer limita){
        super();
        this.setType("Economies");
        this.valoare_minima = valoare_minima;
        this.limita = limita;
    }

    @Override
    public String toString() {
        return "ContEconomiiEntity{" +
                "limita=" + limita +
                ", valoare_minima=" + valoare_minima +
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