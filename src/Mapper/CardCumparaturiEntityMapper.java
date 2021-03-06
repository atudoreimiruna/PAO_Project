package Mapper;

import Entity.CardCumparaturiEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardCumparaturiEntityMapper implements RowMapper<CardCumparaturiEntity> {
    public CardCumparaturiEntity mapRow(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String IBAN = resultSet.getString("IBAN");
        Integer dobanda = resultSet.getInt("dobanda");
        Integer suma_minima_plata = resultSet.getInt("suma_minima_plata");
        Integer suma_maxima_adaugare = resultSet.getInt("suma_maxima_adaugare");

        return new CardCumparaturiEntity(id, IBAN, dobanda, suma_maxima_adaugare, suma_minima_plata);
    }
}
