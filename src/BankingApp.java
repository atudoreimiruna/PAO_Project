import Entity.AdresaEntity;
import Entity.CardEntity;
import Entity.ContEntity;
import Model.*;
import Repository.AdresaRepository;
import Repository.ClientRepository;
import Repository.TranzactieRepository;
import Service.AdresaService;
import Service.CardService;
import Service.ClientService;
import Service.ContService;
import Service.TranzactieService;
import Service.CardCumparaturiService;

import java.text.SimpleDateFormat;
import java.util.*;

public class BankingApp {
    Scanner in = new Scanner(System.in);

    private final Meniu meniuPrincipal;
    private List<Client> clienti = new ArrayList<>();
    private List<Tranzactie> tranzactii = new ArrayList<>();

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
                "Schimba suma tranzactie",
                "Adauga card cumparaturi",
                "Schimba adresa client",
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
                case "schimba_suma_tranzactie" -> this.schimbaSumaTranzactie();
                case "adauga_card_cumparaturi" -> this.adaugaCardCumparaturi();
                case "schimba_adresa_client" -> this.schimbaAdresaClient();
            }
            opt = this.meniuPrincipal.show();
        }
    }

    private void afisareClienti() {
        for (Client c : ClientService.getAll())
            System.out.println(c);

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

    private void adaugaClient() {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nume: ");
            client.setNume(scanner.nextLine());
            System.out.print("Prenume: ");
            client.setPrenume(scanner.nextLine());
            System.out.print("Telefon: ");
            client.setTelefon(scanner.nextLine());
            clienti.add(client);
            ClientService.addClient(client);
            System.out.println("\nOK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void adaugaCardCumparaturi() {
        CardCumparaturi cardCumparaturi = new CardCumparaturi();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Valuta: ");
            cardCumparaturi.setIBAN(scanner.nextLine());

            System.out.print("Dobanda: ");
            cardCumparaturi.setDobanda(scanner.nextInt());

            System.out.print("Suma minima plata: ");
            cardCumparaturi.setSuma_minima_plata(scanner.nextInt());

            System.out.print("Suma maxima adaugare: ");
            cardCumparaturi.setSuma_maxima_adaugare(scanner.nextInt());

            CardCumparaturiService.addCardCumparaturi(cardCumparaturi);
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

    public void schimbaSumaTranzactie(){
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

    public void schimbaAdresaClient(){
        try {
            System.out.print("Introduceti ID adresa: ");
            Scanner scanner = new Scanner(System.in);
            int id_adresa = scanner.nextInt();
            Adresa a = AdresaService.getAdresa(id_adresa);
            if (a == null) {
                throw new Exception("Tranzactia nu exista");
            }
            System.out.print("Introduceti codul postal nou: ");
            in = new Scanner(System.in);
            Integer cod_postal = in.nextInt();
            AdresaRepository.updateCodPostal(id_adresa, cod_postal);
            System.out.println("Codul postal actualizat");
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
