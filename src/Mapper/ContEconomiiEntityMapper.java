package Mapper;

import Entity.ContEconomiiEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContEconomiiEntityMapper implements RowMapper<ContEconomiiEntity>{
    public ContEconomiiEntity mapRow(ResultSet resultSet) throws SQLException {
        Integer valoare_minima = resultSet.getInt("valoare_minima");
        Integer limita= resultSet.getInt("limita");

        return new ContEconomiiEntity(valoare_minima, limita);
    }
}
