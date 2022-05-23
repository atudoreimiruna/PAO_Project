package Service;
import Repository.*;
import Entity.*;
import Model.*;

public class ClientService {
    public static void delete(int id_client){
        ClientRepository.delete(id_client);
        String mesaj = String.format("Clientul cu id-ul " + id_client + " a fost sters cu succes!");
        System.out.println(mesaj);
    }

    public static Client getClient(int id_client){
        ClientEntity c = ClientRepository.find(id_client);
        if (c == null) {
            return null;
        }
        return new Client(c.getId_client(), c.getNume(), c.getPrenume(), c.getEmail(), c.getTelefon());
    }
}
