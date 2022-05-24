package Mapper;

import Entity.AdresaEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresaEntityMapper implements RowMapper<AdresaEntity> {
    public AdresaEntity mapRow(ResultSet resultSet) throws SQLException {
        int id_adresa = resultSet.getInt("id_adresa");
        int ownerId_adresa = resultSet.getInt("ownerId_adresa");

        return new AdresaEntity( id_adresa, ownerId_adresa);
    }
}
