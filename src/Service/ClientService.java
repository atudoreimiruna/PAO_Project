package Service;
import Repository.*;
import Entity.*;
import Model.*;
import java.util.*;

public class ClientService {
    public static void delete(int id_client){
        ClientRepository.delete(id_client);
        // String mesaj = String.format("Clientul cu id-ul " + id_client + " a fost sters cu succes!");
        // System.out.println(mesaj);
    }

    public static Client getClient(int id_client){
        ClientEntity c = ClientRepository.find(id_client);
        if (c == null) {
            return null;
        }
        return new Client(c.getId_client(), c.getNume(), c.getPrenume(), c.getTelefon());
    }

    public static void addClient(Client client){
        ClientEntity c = new ClientEntity(+1, client.getNume(), client.getPrenume(), client.getTelefon());
        ClientRepository.insert(c);
    }

    public static List<Client> getAll() {
        return ClientRepository
                .getAll()
                .stream()
                .map(c -> new Client(c.getId_client(), c.getNume(), c.getPrenume(), c.getTelefon()))
                .toList();
    }
}
