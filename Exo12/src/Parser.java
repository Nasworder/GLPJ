import java.util.Scanner;

/**
 * Une classe qui lit des lignes entrées par l'utilisateur.
 * Les entrées sont vérifiées par getCommand.
 *
 * @author  Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class Parser 
{
    // Contient tous les mots clés des commandes.
    private CommandWords commands;
    private Scanner reader;

    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Lit une commande fournie par l'utilisateur.
     * La commande retournée est toujours une commande valide.
     * @return Une commande valable.
     */
    public String getCommand() 
    {
        String command = null;
        do {
            // Afficher une invite.
            System.out.print("> ");
            
            String word = reader.next();
            // Rejeter le reste de la ligne.
            readLine();
            if(commands.isCommand(word)) {
                command = word;
            }
            else{
                System.out.println("Commande inconnue : " + word);
                System.out.print("Commandes disponibles : ");
                commands.showAll();
            }
        } while(command == null);
    
        return command;
    }

    /**
     * Affiche la liste des commandes valides.
     */
    public void showCommands()
    {
        commands.showAll();
    }

    /**
     * @return Une ligne de texte de l'utilisateur.
     */
    public String readLine()
    {
        return reader.nextLine();
    }
}
