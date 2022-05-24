package Repository;
import Entity.ClientEntity;
import Mapper.ClientEntityMapper;
import java.util.*;

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
        String sql = "insert into client(nume,prenume) values(" +
                addQuotMark(c.getNume()) +
                "," + addQuotMark(c.getPrenume()) + ")";
        int id = executeQuery(sql);
        sql = "insert into client values(" + id + ", " + addQuotMark(c.getTelefon()) + ")";
        executeQuery(sql);
    }

    public static List<ClientEntity> getAll() {
        String sql = "select * from client";
        return readQuery(sql, new ClientEntityMapper());
    }
}
