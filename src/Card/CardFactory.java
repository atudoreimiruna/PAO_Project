package Card;

public class CardFactory {
    private static int Id = 0;

    public Card adaugare_card(String IBAN, String nume, String prenume){
        return new Card(Id++, IBAN, nume, prenume);
    }
    public MasterCard creare_MasterCard(String IBAN, String nume, String prenume){
        return new MasterCard(Id++, IBAN, nume, prenume);
    }
    public Visa creare_VisaCard(String IBAN, String nume, String prenume){
        return new Visa(Id++, IBAN, nume, prenume);
    }
    public Visa creare_cardCumparaturi(String IBAN, String nume, String prenume){
        return new Visa(Id++, IBAN, nume, prenume);
    }
    public Visa creare_cardDebit(String IBAN, String nume, String prenume){
        return new Visa(Id++, IBAN, nume, prenume);
    }
}
