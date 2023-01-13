/**
 * Nom, adresse et numéro de téléphone.
 * 
 * @author David J. Barnes et Michael Kolling.
 * @version 2008.03.30
 */
public class ContactDetails implements Comparable<ContactDetails>
{
    private String name;
    private String phone;
    private String address;

    /**
     * Initialiser les coordonnées. Toutes les informations sont tronquées
     * pour éliminer les espaces en fin de chaîne.
     * @param name Le nom.
     * @param phone Le numéro de téléphone.
     * @param address L'adresse.
     */
    public ContactDetails(String name, String phone, String address)
    {
        // Utiliser une chaîne vide si l'argument est "null".
        if(name == null) {
            name = "";
        }
        if(phone == null) {
            phone = "";
        }
        if(address == null) {
            address = "";
        }
        this.name = name.trim();
        this.phone = phone.trim();
        this.address = address.trim();
    }
    
    /**
     * @return Le nom.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return Le numéro de téléphone.
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * @return L'adresse.
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * Teste l'égalité de contenu de deux objets.
     * @param other L'objet à comparer à celui-ci.
     * @return true Si l'objet en argument est un ensemble
     *              d'informations personnelles dont les attributs correspondent.
     */
    public boolean equals(Object other)
    {
        if(other instanceof ContactDetails) {
            ContactDetails otherDetails = (ContactDetails) other;
            return name.equals(otherDetails.getName()) &&
                    phone.equals(otherDetails.getPhone()) &&
                     address.equals(otherDetails.getAddress());
        }
        else {
            return false;
        }
    }

    /**
     * Compare ces coordonnées à d'autres pour réaliser un tri.
     * Les champs sont ordonnés par nom, téléphone et adresse.
     * @param otherDetails Les coordonnées pour la comparaison.
     * @return un entier négatif si cela vient avant le paramètre,
     *         zéro s'ils sont égaux et un entier positif si cela 
     *         vient après le second.
     */
    public int compareTo(ContactDetails otherDetails)
    {
        int comparison = name.compareTo(otherDetails.getName());
        if(comparison != 0){
            return comparison;
        }
        comparison = phone.compareTo(otherDetails.getPhone());
        if(comparison != 0){
            return comparison;
        }
        return address.compareTo(otherDetails.getAddress());
    }

    /**
     * @return Une chaîne de plusieurs lignes contenant le nom, le n° de téléphone et l'adresse.
     */
    public String toString()
    {
        return name + "\n" + phone + "\n" + address;
    }

    /**
     * Calculer un code de hachage à l'aide des règles se trouvant dans
     * "Effective Java", de Joshua Bloch.
     * @return Un code de hachage pour ContactDetails.
     */
    public int hashCode()
    {
        int code = 17;
        code = 37 * code + name.hashCode();
        code = 37 * code + phone.hashCode();
        code = 37 * code + address.hashCode();
        return code;
    }
}
