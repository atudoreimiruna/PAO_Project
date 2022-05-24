package Service;

import Entity.TranzactieEntity;
import Model.Tranzactie;
import Repository.TranzactieRepository;

import java.util.List;

public class TranzactieService {
    public static void delete(int id_tranzactie){
        TranzactieRepository.delete(id_tranzactie);
    }

    public static Tranzactie getTranzactie(int id_tranzactie){
        TranzactieEntity t = TranzactieRepository.find(id_tranzactie);
        if (t == null) {
            return null;
        }
        return new Tranzactie(t.getId_tranzactie());
    }

    public static List<Tranzactie> getAll() {
        return TranzactieRepository
                .getAll()
                .stream()
                .map(t -> new Tranzactie(t.getId_tranzactie()))
                .toList();
    }

    public static void modificaTranzactie(Tranzactie tranzactie){
        TranzactieRepository.updateSuma(tranzactie.getId_tranzactie(), tranzactie.getSuma_tranzactie());
    }
}
