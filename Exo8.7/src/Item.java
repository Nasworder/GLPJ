/**
 * La classe Item représente un élément multimédia.
 * Les informations sur l'élément sont stockées et peuvent être récupérées.
 * Cette classe sert de superclasse pour des éléments plus spécifiques.
 * 
 * @author Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class Item
{
    private String title;
    private int playingTime;
    private boolean gotIt;
    private String comment;

    /**
     * Initialise les champs de l'élément.
     * @param theTitle Le titre de cet élément.
     * @param time La durée de cet élément.
     */
    public Item(String theTitle, int time)
    {
        title = theTitle;
        playingTime = time;
        gotIt = false;
        comment = "";
    }

    /**
     * Entrer un commentaire pour cet élément.
     * @param comment Le commentaire à saisir.
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * @return Le commentaire pour cet élément.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Définir la balise indiquant si nous possédons cet élément.
     * @param ownIt true si nous possédons l'élément, false autrement.
     */
    public void setOwn(boolean ownIt)
    {
        gotIt = ownIt;
    }

    /**
     * @return true si nous possédons une copie de cet élément.
     */
    public boolean getOwn()
    {
        return gotIt;
    }

    /**
     * Affiche les détails de cet élément sur le terminal de texte.
     */
    public void print()
    {
        System.out.print("titre : " + title + " (" + playingTime + " mn)");
        if(gotIt) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + comment);
    }
}
