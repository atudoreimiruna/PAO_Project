package Service;

import Entity.CardEntity;
import Model.Card;
import Repository.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardService {

    public static List<Card> getAllCards() {
        List<CardEntity> cardEntity = CardRepository.FindAll();
        List<Card> result = new ArrayList<>();

        for( CardEntity cardEntity1: cardEntity) {
            result.add(new Card(cardEntity1.getId(), cardEntity1.getIBAN()));
        }
        return result;
    }
    public static List<Card> getAllCardsForOwner(int ownerId)
    {
        List<CardEntity> cardEntity = CardRepository.findAllForOwner(ownerId);
        List<Card> result = new ArrayList<>();

        for( CardEntity cardEntity1: cardEntity) {
            result.add(new Card(cardEntity1.getId(), cardEntity1.getIBAN()));
        }
        return result;
    }
}
