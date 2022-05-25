package Model;

public class ContCurent extends Cont {
    Integer suma_curenta;

    ContCurent(Integer id, Integer suma_curenta){
        super(id);
        this.setType("Standard");
        this.suma_curenta = suma_curenta;
    }

    public Integer getSuma_curenta() {
        return suma_curenta;
    }

    public void setSuma_curenta(Integer suma_curenta) {
        this.suma_curenta = suma_curenta;
    }

    @Override
    public String toString() {
        return "ContCurent{" +
                "suma_curenta=" + suma_curenta +
                '}';
    }
}