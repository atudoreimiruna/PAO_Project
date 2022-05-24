package Mapper;

import Entity.CardEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardEntityMapper implements RowMapper<CardEntity> {
    public CardEntity mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String IBAN = resultSet.getString("IBAN");
        int ownerId = resultSet.getInt("ownerId");

        return new CardEntity(id, IBAN, ownerId);
    }
}
