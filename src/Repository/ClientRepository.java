package Repository;
import Entity.ClientEntity;
import Mapper.ClientEntityMapper;

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
}
