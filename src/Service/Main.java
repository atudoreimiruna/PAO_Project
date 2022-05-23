package Service;

public class Main {
    public static void main(String[] args) {

        // afisare toate cardurile
        System.out.println(CardService.getAllCards());

        // afisare toate conturile
        System.out.println(ContService.getAllConts());

        System.out.println(ClientService.getClient(1));
    }
}