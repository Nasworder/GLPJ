/**
 * Cette classe contient la liste des mots clés des commandes
 * connues du programme.
 *
 * @author Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class CommandWords {
    // un tableau constant contenant tous les mots clés des commandes.
    private static final String validCommands[] = {
            "ajouter", "retirer", "chercher", "modifier", "lister", "aide", "quitter",
    };

    /**
     * Constructeur pour CommandWords
     */
    public CommandWords() {
    }

    /**
     * Vérifie si la chaîne entrée est une commande valide.
     *
     * @param aString La chaîne à vérifier.
     * @return true si elle est valable, false sinon.
     */
    public boolean isCommand(String aString) {
        if (aString != null) {
            for (int i = 0; i < validCommands.length; i++) {
                if (validCommands[i].equals(aString))
                    return true;
            }
        }
        // si nous sommes ici, la chaîne n'est pas une commande valide.
        return false;
    }

    /**
     * Afficher toutes les commandes possibles sur System.out.
     */
    public void showAll() {
        for (String command : validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
