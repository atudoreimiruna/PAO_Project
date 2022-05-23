package Model;

import Model.Cont;

public class ContCurent extends Cont {

    ContCurent(String nume, Integer id){
        super(nume, id);
        this.setType("Standard");
    }

}
