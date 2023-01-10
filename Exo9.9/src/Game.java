/**
 *  Cette classe est la classe principale de l'application "le monde de Zuul".
 * "Le monde de Zuul" est un jeu d'aventures très simple en mode texte.  
 * Les utilisateurs peuvent se promener dans le décor. C'est tout. 
 * Il devrait vraiment être étendu pour le rendre plus intéressant !
 * 
 *  Pour jouer à ce jeu,  créez une instance de cette classe 
 * et appelez la méthode "play".
 * 
 *  Cette classe principale crée et initialise tous les autres: 
 * elle crée toutes les pièces, crée l'analyseur syntaxique et démarre le jeu. 
 * Elle évalue aussi et exécute les commandes renvoyées par l'analyseur syntaxique. 
 * 
 * @author  Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Création du jeu et initialisation de sa carte interne.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Création des pièces et des liens entre les sorties des pièces
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office, transportRoom;
      
        // création des pièces
        outside = new Room("à l'extérieur de l'entrée principale de l'Université");
        theatre = new Room("dans un amphithéâtre");
        pub = new Room("à la cafétéria");
        lab = new Room("dans la salle informatique");
        office = new Room("au bureau des techniciens");
        transportRoom = new TransporterRoom("dans la salle de transport");

        
        // initialisation des sorties des pièces
        outside.setExit("est", theatre);
        outside.setExit("sud", lab);
        outside.setExit("ouest", pub);
        outside.setExit("nord", transportRoom);

        theatre.setExit("ouest", outside);

        pub.setExit("est", outside);

        lab.setExit("nord", outside);
        lab.setExit("est", office);

        office.setExit("ouest", lab);

        transportRoom.setExit("sud", outside);
        transportRoom.setExit("nord", theatre);
        transportRoom.setExit("est", pub);
        transportRoom.setExit("ouest", lab);
        transportRoom.setExit("nord-est", lab);


        currentRoom = outside;  // début de la partie dehors
    }

    /**
     *  Fonction principale de jeu. Boucle jusqu'à la fin du jeu.
     */
    public void play() 
    {            
        printWelcome();

        // Entrée dans la boucle principale des commandes.  Ici, nous répétons la lecture et l'exécution 
        // des commandes jusqu'à la fin du jeu.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Merci d'avoir joué. Au revoir.");
    }

    /**
     * Affichage du message d'accueil au joueur.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Bienvenue au jeu de Zuul !");
        System.out.println("Zuul est un nouveau jeu d'aventure terriblement ennuyeux.");
        System.out.println("Tapez 'aide' si vous avez besoin d'aide.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Etant donné une commande, traiter (exécuter) la commande.
     * @param command La commande à traiter.
     * @return true si la commande termine le jeu, false autrement.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Je ne comprends pas cette commande...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("aide")) {
            printHelp();
        }
        else if (commandWord.equals("aller")) {
            goRoom(command);
        }
        else if (commandWord.equals("quitter")) {
            wantToQuit = quit(command);
        }
        // sinon, la commande n'est pas reconnue.
        return wantToQuit;
    }

    // implantation des commandes :

    /**
     * Affichage de l'aide.
     * Nous affichons ici quelques messages stupides, mystérieux et 
     * une liste des ordres.
     */
    private void printHelp() 
    {
        System.out.println("Vous êtes perdu. Vous êtes seul. Vous errez");
        System.out.println("dans l'université.");
        System.out.println();
        System.out.println("Les commandes sont :");
        parser.showCommands();
    }

    /** 
     * Essai de déplacement dans une direction. 
     * Si une sortie existe, nous entrons dans la nouvelle pièce,           
     * sinon afficher un message d'erreur
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // en cas d'absence du deuxième mot,  nous ne savons pas où aller
            System.out.println("Aller où ?");
            return;
        }

        String direction = command.getSecondWord();

        // nous essayons de quitter la pièce courante.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Il n'y a pas de porte !");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quitter" vient d'être saisi. Vérification du deuxième mot de la commande
     * pour s'assurer que nous voulons réellement quitter le jeu.
     * @return true si cette commande termine le jeu, false autrement.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quitter quoi ?");
            return false;
        }
        else {
            return true;  // informe que nous voulons quitter le jeu
        }
    }
}
