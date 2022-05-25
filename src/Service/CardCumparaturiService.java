package Service;

import Entity.CardCumparaturiEntity;
import Model.CardCumparaturi;
import Repository.CardCumparaturiRepository;

public class CardCumparaturiService {

    public static void addCardCumparaturi(CardCumparaturi cardCumparaturi){
        CardCumparaturiEntity cc = new CardCumparaturiEntity(+1, cardCumparaturi.getIBAN(), cardCumparaturi.getDobanda(), cardCumparaturi.getSuma_minima_plata(), cardCumparaturi.getSuma_maxima_adaugare());
        CardCumparaturiRepository.insert(cc);
    }
}
