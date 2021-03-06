package Mapper;

import Entity.ClientEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientEntityMapper implements RowMapper<ClientEntity> {
    public ClientEntity mapRow(ResultSet resultSet) throws SQLException {
        int id_client = resultSet.getInt("id_client");
        String nume = resultSet.getString("nume");
        String prenume = resultSet.getString("prenume");
        String telefon = resultSet.getString("telefon");

        return new ClientEntity(id_client, nume, prenume, telefon);
    }
}
