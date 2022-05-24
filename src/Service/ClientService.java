package Service;

import Entity.ClientEntity;
import Model.Client;
import Repository.ClientRepository;

import java.util.List;

public class ClientService {
    public static void delete(int id_client){
        ClientRepository.delete(id_client);
    }

    public static void updateClient(Client client, int id_client)
    {
        ClientRepository.update(client, id_client);
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

    public static void modificaTelefon(Client client){
        ClientRepository.updateTelefon(client.getId_client(), client.getTelefon());
    }
}
