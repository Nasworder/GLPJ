/**
 * Une interface en mode texte pour la classe AddressBook.
 * Plusieurs commandes donnent accès aux données du carnet d'adresses.
 *
 *      une pour la recherche dans le carnet d'adresses.
 *
 *      une pour entrer les coordonnées d'un contact.
 *
 *      une pour visualiser toutes les entrées du carnet.
 *
 * @author David J. Barnes et Michael Kolling.
 * @version 2008.03.30
 */
public class AddressBookTextInterface
{
    // Le carnet d'adresses à visualiser et manipuler.
    private AddressBook book;
    // Un analyseur pour gérer les commandes utilisateur.
    private Parser parser;
    
    /**
     * Constructeur d'objets de la classe AddressBookTextInterface
     * @param book Le carnet d'adresses à gérer.
     */
    public AddressBookTextInterface(AddressBook book)
    {
        this.book = book;
        parser = new Parser();
    }
    
    /**
     * Lit une commande utilisateur pour interagir avec le carnet d'adresses.
     * Termine quand l'utilisateur entre 'quitter'.
     */
    public void run()
    {
        System.out.println("Carnet d'adresses.");
        System.out.println("Entrez 'aide' pour la liste des commandes.");
        
        String command;
        do{
            command = parser.getCommand();
            if(command.equals("ajouter")){ 
                add();
            }
            else if(command.equals("retirer")){
                remove();
            }
            else if(command.equals("modifier")){
                modify();
            }
            else if(command.equals("lister")){
                list();
            }
            else if(command.equals("chercher")){
                find();
            }
            else if(command.equals("aide")){
                help();
            }
            else{
                // Ne rien faire.
            }
        } while(!(command.equals("quitter")));

        System.out.println("Au revoir.");
    }
    
    /**
     * Ajoute une entrée.
     */
    private void add()
    {
        System.out.print("Nom : ");
        String name = parser.readLine();
        System.out.print("Téléphone : ");
        String phone = parser.readLine();
        System.out.print("Adresse : ");
        String address = parser.readLine();

        try {
            book.addDetails(new ContactDetails(name, phone, address));
        } catch (DuplicateKeyException e) {
            System.out.println(e);
        }
    }

/**
     * Retire une entrée.
     */
    private void remove(){
        System.out.println("Entrez un préfixe de la clé à retirer :");
        String key = parser.readLine();
        book.removeDetails(key);
    }


    /**
     * Modifie une entrée.
     */
    private void modify(){
        System.out.println("Entrez un préfixe de la clé à modifier :");
        String key = parser.readLine();
        ContactDetails details = book.getDetails(key);

        if(details != null){
            System.out.print("Nom [" + details.getName() +"]: ");
            String name = parser.readLine();
            System.out.print("Téléphone [" + details.getPhone() +"]: ");
            String phone = parser.readLine();
            System.out.print("Adresse [" + details.getAddress() +"]: ");
            String address = parser.readLine();

            if (name.equals("")) {
                name = details.getName();
            }
            if (phone.equals("")) {
                phone = details.getPhone();
            }
            if (address.equals("")) {
                address = details.getAddress();
            }

            try {
                book.changeDetails(key, new ContactDetails(name, phone, address));
            } catch (DuplicateKeyException e) {
                System.out.println(e);
            }
        }
        else{
            System.out.println("Aucune entrée ne correspond à cette clé.");
        }



    }

    /**
     * Trouver les entrées de préfixe donné.
     */
    private void find()
    {
        System.out.println("Entrez un préfixe de la clé à trouver.");
        String prefix = parser.readLine();
        ContactDetails[] results = book.search(prefix);
        for(int i = 0; i < results.length; i++){
            System.out.println(results[i]);
            System.out.println("=====");
        }
    }
    
    /**
     * Liste les commandes disponibles.
     */
    private void help()
    {
        parser.showCommands();
    }
    
    /**
     * Liste le contenu du carnet d'adresses.
     */
    private void list()
    {
        System.out.println(book.listDetails());
    }
}
