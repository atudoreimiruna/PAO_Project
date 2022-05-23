package Mapper;

import Entity.ContEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContEntityMapper implements RowMapper<ContEntity> {
    public ContEntity mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nume = resultSet.getString("nume");

        return new ContEntity(nume, id);
    }
}
