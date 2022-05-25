package Repository;

import Entity.CardCumparaturiEntity;

public class CardCumparaturiRepository extends Repository{

    public static void insert(CardCumparaturiEntity c) {
        String sql = "insert into cardcumparaturi(valuta, dobanda, suma_minima_plata, suma_maxima_adaugare) values(" +
                addQuotMark(c.getValuta()) +
                "," + addQuotMarkI(c.getDobanda()) +
                "," + addQuotMarkI(c.getSuma_minima_plata()) +
                "," + addQuotMarkI(c.getSuma_maxima_adaugare()) + ")";
        executeQuery(sql);
    }
}
