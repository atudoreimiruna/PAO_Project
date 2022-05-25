package Mapper;

import Entity.TranzactieEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TranzactieEntityMapper implements RowMapper<TranzactieEntity> {

    public TranzactieEntity mapRow(ResultSet resultSet) throws SQLException {
        Integer id_tranzactie = resultSet.getInt("id_tranzactie");

        return new TranzactieEntity(id_tranzactie);
    }
}

