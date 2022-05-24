package Repository;

import Entity.TranzactieEntity;
import Mapper.TranzactieEntityMapper;

import java.util.List;

public class TranzactieRepository extends Repository{
    public static TranzactieEntity find(int id_tranzactie){
        try {
            return readQuery("select * from tranzactie where id_tranzactie=" + id_tranzactie, new TranzactieEntityMapper()).get(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    public static void delete(int id_tranzactie){
        executeQuery("delete from tranzactie where id_tranzactie=" + id_tranzactie);
    }
    public static List<TranzactieEntity> getAll() {
        String sql = "select * from tranzactie";
        return readQuery(sql, new TranzactieEntityMapper());
    }

    public static void updateSuma(Integer id_tranzactie, Integer suma_tranzactie) {
        if(suma_tranzactie == null){
            executeQuery("update Tranzactie set suma_tranzactie = null where id_tranzactie=" + id_tranzactie);
        } else {
            executeQuery("update Tranzactie set suma_tranzactie =" + suma_tranzactie + " where id_tranzactie=" + id_tranzactie);
        }
    }
}
