/**
 * Cette classe fait partie de l'application "le monde de Zuul".
 * "Le monde de Zuul" est un jeu d'aventures très simple en mode texte.
 *
 * Cette classe stocke les informations concernant une commande de l'utilisateur.
 * Une commande consiste actuellement en deux chaînes : un mot d'instruction et 
 * un deuxième mot (par exemple, si la commande était "prendre carte", 
 * alors les deux chaînes sont évidemment "prendre" et "carte").
 * 
 * Voici l'utilisation qui en est faite : les commandes sont déjà vérifiées pour 
 * être des mots d'instruction valides. Si l'utilisateur avait entré une commande erronée 
 * (un mot qui n'est pas connu) alors le mot d'instruction est <null>.
 *
 * Si la commande n'est constituée que d'un seul mot, le second est alors <null>.
 * 
 * @author  Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Création d'un objet de type command. Le premier et le second mot doivent être fournis, 
     * mais l'un ou l'autre (ou les deux) peuvent être null. 
     * @param firstWord Le premier mot de la commande. Null si la commande
     *                  n'a pas été reconnue.
     * @param secondWord Le second mot de la commande.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Renvoie le mot d'instruction (le premier mot) de la commande.
     * Si la commande n'est pas comprise, le résultat est null.
     * @return La commande.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return Le deuxième mot de cette commande. Renvoie null s'il n'y
     * avait pas de deuxième mot.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return true si la commande n'a pas été comprise.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * @return true si la commande est composée de deux mots.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

