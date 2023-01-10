import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Cette classe fait partie de l'application "le monde de Zuul".
 * "Le monde de Zuul" est un jeu d'aventures très simple en mode texte.
 * 
 * Cet analyseur lit les entrées de l'utilisateur et essaie de les interpréter
 * comme une commande du jeu. A chaque fois qu'il est appelé, l'analyseur lit
 * une ligne en utilisant le terminal et essaie de l'interpéter comme une 
 * commande de deux mots. L'analyseur renvoie la commande comme un objet de 
 * de type command.
 *
 * L'analyseur possède un ensemble de mots connus pour les commandes. Il 
 * vérifie les saisies de l'utilisateur à l'aide des commandes connues
 * et si une entrée n'est pas reconnue comme une commande, il renvoie
 * un objet de type command qui est marqué comme une commande inconnue
 * 
 * @author  Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class Parser 
{
    private CommandWords commands;  // stocke toutes les commandes valides
    private Scanner reader;         // source d'entrée de commande

    /**
     * Crée un analyseur pour lire à partir de la fenêtre du terminal.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return La commande suivante de l'utilisateur.
     */
    public Command getCommand() 
    {
        String inputLine;   // contiendra la ligne d'entrée dans sa totalité
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // affiche l'invite

        inputLine = reader.nextLine();

        // Trouver jusqu'à deux mots sur la ligne.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // récupération du premier mot
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // récupération du deuxième mot
        // à noter : nous ignorons simplement la fin de la ligne
            }
        }

        // Nous vérifions maintenant si le mot est connu. Si c'est le cas, nous
        // créons un objet de type command. Dans le cas contraire, nous créons 
        // une commande "null".
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }

    /**
     * Affiche une liste de commandes valables.
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
