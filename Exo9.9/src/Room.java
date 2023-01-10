import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Classe Room - une pièce dans un jeu d'aventures.
 *
 * Cette classe fait partie de l'application "le monde de Zuul".
 * "Le monde de Zuul" est un jeu d'aventures très simple en mode texte.
 *
 * Une pièce ("Room") représente un lieu dans le scénario du jeu.
 * Elle est reliée à d'autres pièces à l'aide de sorties. Pour chaque sortie, la pièce
 * conserve une référence à la pièce voisine.
 * 
 * @author  Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // conserve les sorties de cette pièce.

    /**
     * Crée une pièce décrite par la chaîne "description". Au départ, il n'existe 
     * aucune sortie. "description" est une chaîne comme "une cuisine" ou
     * "une cour de jardin".
     * @param description La description de la pièce.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Définit une sortie de cette pièce.
     * @param direction La direction de la sortie.
     * @param neighbor  La pièce vers laquelle mène la sortie.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return La description courte de la pièce
     * (celle définie dans le constructeur).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Renvoie une description de la pièce sous la forme :
     *     Vous êtes dans la cuisine.
     *     Sorties : nord ouest
     * @return Une description longue de cette pièce
     */
    public String getLongDescription()
    {
        return "Vous êtes " + description + ".\n" + getExitString();
    }

    /**
     * Renvoie une chaîne décrivant la sortie de la pièce, par exemple
     * "Sorties : nord ouest".
     * @return Détail des sorties de la pièce.
     */
    private String getExitString()
    {
        String returnString = "Sorties :";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Renvoie la pièce atteinte si nous allons de cette pièce en direction de
     * "direction". S'il n'y a pas de pièce dans cette direction, renvoie null.
     * @param direction La direction de la sortie.
     * @return La pièce dans la direction donnée.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

