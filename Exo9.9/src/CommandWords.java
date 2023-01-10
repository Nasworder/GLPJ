/**
 * Cette classe fait partie de l'application "le monde de Zuul".
 * "Le monde de Zuul" est un jeu d'aventures très simple en mode texte.
 * 
 * Cette classe stocke une énumération de toutes les commandes 
 * connues par le jeu. Elle est utilisée pour reconnaître les commandes lors de la saisie.
 *
 * @author  Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */

public class CommandWords
{
    // un tableau de constantes qui contient toutes les commandes
    private static final String[] validCommands = {
        "aller", "quitter", "aide"
    };

    /**
     * Constructeur - initialise les commandes.
     */
    public CommandWords()
    {
        // rien à faire pour l'instant...
    }

    /**
     * Vérifie si une chaîne de caractères donnée est une commande valide.
     * @return true si c'est le cas, false dans le cas contraire.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // si nous arrivons ici, la chaîne de caractères n'est pas une commande
        return false;
    }

    /**
     * Affiche toutes les commandes valides sur System.out.
     */
    public void showAll() 
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
