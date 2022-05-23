package Service;

import Entity.CardEntity;
import Model.Card;

import java.util.*;

public class CardService {

    public static List<Card> getAllCards() {
        List<CardEntity> cardEntity = DatabaseQueryExecutorService.executeReadQuery();
        List<Card> result = new ArrayList<>();

        for( CardEntity cardEntity1: cardEntity) {
            result.add(new Card(cardEntity1.getId(), cardEntity1.getIBAN(), cardEntity1.getNume(), cardEntity1.getPrenume()));
        }
        return result;
    }
}
