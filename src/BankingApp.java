import Entity.AdresaEntity;
import Entity.CardEntity;
import Entity.ContEntity;
import Model.Client;
import Model.Cont;
import Model.Tranzactie;
import Repository.ClientRepository;
import Repository.TranzactieRepository;
import Service.AdresaService;
import Service.CardService;
import Service.ClientService;
import Service.ContService;
import Service.TranzactieService;

import java.text.SimpleDateFormat;
import java.util.*;

public class BankingApp {
    Scanner in = new Scanner(System.in);

    private final Meniu meniuPrincipal;
    private List<Client> clienti = new ArrayList<>();
    private List<Tranzactie> tranzactii = new ArrayList<>();
    // private Integer id;

    public BankingApp() {
        this.meniuPrincipal = new Meniu(Arrays.asList(
                "Adauga client",
                "Sterge client",
                "Afisare clienti",
                "Afisare conturi",
                "Afisare conturi client",
                "Afisare carduri cont",
                "Afisare adrese client",
                "Schimba telefon client",
                "StergeTranzactie",
                "AfisareTranzactii",
                "Schimba suma tranzactie",
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
                case "afisare_conturi" -> this.afisareConturi();
                case "afisare_conturi_client" -> this.afisareConturiClient();
                case "afisare_carduri_cont" -> this.afisareCarduriCont();
                case "afisare_adrese_client" -> this.afisareAdreseClient();
                case "schimba_telefon_client" -> this.schimbaTelefonClient(in);
                case "sterge_tranzactie" -> this.stergeTranzactie(in);
                case "afisare_tranzactii" -> this.afisareTranzactii(in);
                case "schimba_suma_tranzactie" -> this.schimbaSumaTranzactie(in);
            }
            opt = this.meniuPrincipal.show();
        }
    }

    private void afisareClienti() {
        for (Client c : ClientService.getAll())
            System.out.println(c);

        System.out.println("---------------------------------------------------");
    }

    private void afisareTranzactii(Scanner in) {
        for (Tranzactie t : TranzactieService.getAll())
            System.out.println(t);

        System.out.println("---------------------------------------------------");
    }

    private void afisareConturi() {
        for (Cont c : ContService.getAllConts())
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

    private void afisareCarduriCont() {
        CardEntity card = new CardEntity();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("OwnerId Cont: ");
            card.setOwnerId(scanner.nextInt());
            System.out.println(CardService.getAllCardsForOwner(card.getOwnerId()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void afisareAdreseClient() {
        AdresaEntity adresa = new AdresaEntity();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("OwnerId Client: ");
            adresa.setOwnerId_adresa(scanner.nextInt());
            System.out.println(AdresaService.getAllAddressesForOwner(adresa.getOwnerId_adresa()));

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
            clienti.add(client);
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
            System.out.println("\nClientul a fost sters!");
        } catch (InputMismatchException e) {
            System.out.println("ID invalid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void stergeTranzactie(Scanner in) {
        try {
            System.out.print("Id tranzactie: ");
            Scanner scanner = new Scanner(System.in);
            int id_tranzactie = scanner.nextInt();
            Tranzactie t = TranzactieService.getTranzactie(id_tranzactie);
            if (t == null) {
                throw new Exception("Tranzactia nu exista");
            }
            TranzactieService.delete(id_tranzactie);
            System.out.println("\nTranzactia a fost stearsa!");
        } catch (InputMismatchException e) {
            System.out.println("ID invalid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void schimbaSumaTranzactie(Scanner in){
        try {
            System.out.print("Introduceti ID tranzactie");
            Scanner scanner = new Scanner(System.in);
            int id_tranzactie = scanner.nextInt();
            Tranzactie t = TranzactieService.getTranzactie(id_tranzactie);
            if (t == null) {
                throw new Exception("Tranzactia nu exista");
            }
            System.out.print("Introduceti suma noua: ");
            in = new Scanner(System.in);
            Integer suma_noua = in.nextInt();
            TranzactieRepository.updateSuma(id_tranzactie, suma_noua);
            System.out.println("Suma actualizata");
        } catch (InputMismatchException e) {
            System.out.println("ID invalid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void schimbaTelefonClient(Scanner in) {
        try {
            System.out.println("Introduceti ID client");
            Scanner scanner = new Scanner(System.in);
            int id_client = scanner.nextInt();
            Client c = ClientService.getClient(id_client);
            if (c == null) {
                throw new Exception("Clientul nu exista");
            }
            System.out.println("Introduceti numarul de telefon nou: ");
            in = new Scanner(System.in);
            String telefon_nou = in.nextLine();
            ClientRepository.updateTelefon(id_client, telefon_nou);
            System.out.println("Telefon actualizat");
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
