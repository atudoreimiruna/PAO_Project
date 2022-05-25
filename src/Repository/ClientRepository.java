package Repository;

import Entity.ClientEntity;
import Mapper.ClientEntityMapper;
import Model.Client;

import java.util.List;

public class ClientRepository extends Repository{

    public static void delete(int id_client){
        executeQuery("delete from Client where id_client=" + id_client);
    }

    public static ClientEntity find(int id_client){
        try {
            return readQuery("select * from Client where id_client=" + id_client, new ClientEntityMapper()).get(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static void insert(ClientEntity c) {
        String sql = "insert into client(nume,prenume,telefon) values(" +
                addQuotMark(c.getNume()) +
                "," + addQuotMark(c.getPrenume()) +
                "," + addQuotMark(c.getTelefon()) + ")";
        // int id = executeQuery(sql);
        // sql = "insert into client values(" + id + ", " + addQuotMark(c.getTelefon()) + ")";
        executeQuery(sql);
    }

    public static List<ClientEntity> getAll() {
        String sql = "select * from client";
        return readQuery(sql, new ClientEntityMapper());
    }

    public static void update(Client client, int id_client) {
        String sql = "update client set telefon = " +
                addQuotMark(client.getTelefon()) + " where id = " + id_client;
        executeQuery(sql);
    }

    public static void updateTelefon(Integer id_client, String telefon) {
        if(telefon == null){
            executeQuery("update Client set telefon = null where id_client=" + id_client);
        } else {
            executeQuery("update Client set telefon =" + telefon + " where id_client=" + id_client);
        }
    }
}
