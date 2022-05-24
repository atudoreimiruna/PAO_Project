package Mapper;

import Entity.ContEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContEntityMapper implements RowMapper<ContEntity> {
    public ContEntity mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int ownerId_cont = resultSet.getInt("ownerId_cont");

        return new ContEntity( id, ownerId_cont);
    }
}
