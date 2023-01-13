import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Une classe pour gérer les coordonnées d'un nombre quelconque de contacts.
 * Les coordonnées sont indexées par le nom et le numéro de téléphone.
 *
 * @author David J. Barnes et Michael Kolling.
 * @version 2008.03.30
 */
public class AddressBook {
    // Enregistrement d'un nombre quelconque de contacts.
    private TreeMap<String, ContactDetails> book;
    private int numberOfEntries;

    /**
     * Initialise un carnet d'adresses.
     */
    public AddressBook() {
        book = new TreeMap<String, ContactDetails>();
        numberOfEntries = 0;
    }

    /**
     * Recherche un nom ou un numéro de téléphone et renvoie
     * les coordonnées du contact correspondant.
     *
     * @param key Le nom ou le numéro à chercher.
     * @return Les informations correspondant à la clé.
     */
    public ContactDetails getDetails(String key) {
        return book.get(key);
    }

    /**
     * Renvoie si oui ou non la clé est utilisée.
     *
     * @param key Le nom ou le numéro à chercher.
     * @return true si la clé est utilisée, false sinon.
     */
    public boolean keyInUse(String key) {
        return book.containsKey(key);
    }

    /**
     * Ajoute un nouveau contact au carnet d'adresses.
     *
     * @param details Les coordonnées à associer à la personne.
     */
    public void addDetails(ContactDetails details) throws DuplicateKeyException {


        if (book.get(details.getName()) != null && book.get(details.getPhone()) != null) {
            throw new DuplicateKeyException(details.getName() + " and " + details.getPhone());
        }
        else if (book.get(details.getName()) != null) {
            throw new DuplicateKeyException(details.getName());
        }
        else if (book.get(details.getPhone()) != null) {
            throw new DuplicateKeyException(details.getPhone());
        }

        System.out.println("Adding " + details.getName() + " " + details.getPhone() + " " + details.getAddress());
        book.put(details.getName(),details);
        book.put(details.getPhone(),details);
        numberOfEntries++;
    }

    /**
     * Modifie les coordonnées précédemment enregistrées sous la clé donnée.
     *
     * @param oldKey  L'une des clés utilisées pour stocker les contacts.
     * @param details Les coordonnées de remplacement.
     */
    public void changeDetails(String oldKey, ContactDetails details) throws DuplicateKeyException {
        removeDetails(oldKey);
        addDetails(details);
    }

    /**
     * Cherche toutes les coordonnées stockées correspondant à une clé
     * commençant par le préfixe fourni.
     *
     * @param keyPrefix Le préfixe de recherche.
     * @return Un tableau des informations trouvées.
     */
    public ContactDetails[] search(String keyPrefix) {
        // Construire une liste des informations qui correspondent.
        List<ContactDetails> matches = new LinkedList<ContactDetails>();
        // Trouver les clés supérieures ou égales au préfixe.
        SortedMap<String, ContactDetails> tail = book.tailMap(keyPrefix);
        Iterator<String> it = tail.keySet().iterator();
        // Arrêter lorsqu'il n'y a plus concordance.
        boolean endOfSearch = false;
        while (!endOfSearch && it.hasNext()) {
            String key = it.next();
            if (key.startsWith(keyPrefix)) {
                matches.add(book.get(key));
            } else {
                endOfSearch = true;
            }
        }
        ContactDetails[] results = new ContactDetails[matches.size()];
        matches.toArray(results);
        return results;
    }

    /**
     * @return Le nombre d'entrées actuellement
     * dans le carnet d'adresses.
     */
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    /**
     * Supprime une entrée de clé donnée du carnet d'adresses.
     *
     * @param key Une des clés de l'entrée à supprimer.
     */
    public void removeDetails(String key) {

        try {
            if (book.get(key) == null || book.get(key).getPhone() == null) {
                throw new NoMatchingDetailsException(key);
            }

            ContactDetails details = book.get(key);
            book.remove(details.getName());
            book.remove(details.getPhone());
            numberOfEntries--;
        } catch (NoMatchingDetailsException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @return Une liste de toutes les coordonnées des contacts, classées selon
     * l'ordre de tri de la classe ContactDetails.
     */
    public String listDetails() {
        // Comme chaque entrée est stockée sous deux clés,
        // il faut construire un ensemble des coordonnées des contacts
        // pour éliminer les doublons.
        StringBuffer allEntries = new StringBuffer();
        Set<ContactDetails> sortedDetails = new TreeSet<ContactDetails>(book.values());
        for (ContactDetails details : sortedDetails) {
            allEntries.append(details);
            allEntries.append('\n');
            allEntries.append('\n');
        }
        return allEntries.toString();
    }


}
