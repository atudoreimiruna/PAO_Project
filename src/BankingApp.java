import Entity.ContEntity;
import Model.Client;
import Service.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BankingApp {

    private final Meniu meniuPrincipal;
    private Integer id;

    public BankingApp() {
        this.meniuPrincipal = new Meniu(Arrays.asList(
                "Adauga client",
                "Sterge client",
                "Afisare clienti",
                "Afisare conturi client",
                "Exit"
        ));
    }

    public void meniu() {
        String opt = this.meniuPrincipal.show();
        while (!(opt.equals("exit"))) {
            this.logAction(opt);
            switch (opt) {
                case "adauga_client" -> this.adaugaClient();
                case "sterge_client" -> this.stergeClient();
                case "afisare_clienti" -> this.afisareClienti();
                case "afisare_conturi_client" -> this.afisareConturiClient();
            }
            opt = this.meniuPrincipal.show();
        }
    }

    private void afisareClienti() {
        for (Client c : ClientService.getAll())
            System.out.println(c);

        System.out.println("---------------------------------------------------");
    }

    private void afisareConturiClient() {
        ContEntity cont = new ContEntity();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("OwnerId Client: ");
            cont.setOwnerId_cont(scanner.nextInt());
            System.out.println(ContService.getAllContsForOwner(cont.getOwnerId_cont()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void citireClient(Client client, Scanner scanner) throws Exception {
        System.out.print("Nume: ");
        client.setNume(scanner.nextLine());
        System.out.print("Prenume: ");
        client.setPrenume(scanner.nextLine());
        // System.out.print("Telefon: ");
        // client.setTelefon(scanner.nextLine());
    }

    private void adaugaClient() {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        try {
            citireClient(client, scanner);
            // System.out.print("Email: ");
            // client.setEmail(scanner.nextLine());
            System.out.print("Telefon: ");
            client.setTelefon(scanner.nextLine());

            ClientService.addClient(client);
            System.out.println("\nOK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void stergeClient() {
        try {
            System.out.print("ID client: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            Client c = ClientService.getClient(id);
            if (c == null) {
                throw new Exception("Clientul nu exista");
            }
            ClientService.delete(id);
            System.out.println("\nOK");
        } catch (InputMismatchException e) {
            System.out.println("ID invalid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void logAction(String action) {
        String timp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        Writer f = Writer.getInstance();
        try {
            f.appendCsvFile(new String[]{action, timp}, "audit/audit.csv");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
