/**
 * Une démonstration élémentaire d'utilisation de la classe AddressBook.
 * Quelques données sont placées dans le carnet d'adresses
 * et une interface texte est fournie.
 * 
 * @author David J. Barnes et Michael Kolling.
 * @version 2008.03.30
 */
public class AddressBookDemo
{
    private AddressBook book;
    private AddressBookTextInterface interaction;

    /**
     * Construire un carnet d'adresses avec quelques données.
     * Le carnet d'adresses est transmis à une interface graphique
     * pour visualisation.
     */
    public AddressBookDemo()
    {
        ContactDetails[] sampleDetails = {
            new ContactDetails("david",   "08459 100000", "adresse 1"),
            new ContactDetails("michael", "08459 200000", "adresse 2"),
            new ContactDetails("john",    "08459 300000", "adresse 3"),
            new ContactDetails("helen",   "08459 400000", "adresse 4"),
            new ContactDetails("emma",    "08459 500000", "adresse 5"),
            new ContactDetails("kate",    "08459 600000", "adresse 6"),
            new ContactDetails("chris",   "08459 700000", "adresse 7"),
            new ContactDetails("ruth",    "08459 800000", "adresse 8"),
        };
        book = new AddressBook();
        for(ContactDetails details : sampleDetails) {
            try {
                book.addDetails(details);
            } catch (DuplicateKeyException e) {
                System.out.println(e.getMessage());
            }
        }
        interaction = new AddressBookTextInterface(book);
    }

    /**
     * Permet à l'utilisateur d'interagir avec le carnet d'adresses.
     */
    public void showInterface()
    {
        interaction.run();
    }

    /**
     * @return Le carnet d'adresses d'exemple
     */
    public AddressBook getBook()
    {
        return book;
    }
}
