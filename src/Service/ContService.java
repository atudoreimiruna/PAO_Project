package Service;

import Entity.ContEntity;
import Model.Card;
import Model.Cont;
import Repository.ContRepository;

import java.util.ArrayList;
import java.util.List;

public class ContService {
    public static List<Cont> getAllConts() {
        List<ContEntity> contEntity = ContRepository.FindAll();
        List<Cont> result = new ArrayList<>();

        for( ContEntity contEntity1: contEntity) {
            Cont cont = new Cont(contEntity1.getNume(), contEntity1.getId());
            List<Card> cards = CardService.getAllCardsForOwner(contEntity1.getId());
            cont.setCarduri(cards);
            result.add(cont);
        }
        return result;
    }

    public static List<Cont> getAllContsForOwner(int ownerId_cont)
    {
        List<ContEntity> contEntity = ContRepository.findAllForOwner(ownerId_cont);
        List<Cont> result = new ArrayList<>();

        for( ContEntity contEntity1: contEntity) {
            result.add(new Cont(contEntity1.getNume(), contEntity1.getId()));
        }
        return result;
    }
}
