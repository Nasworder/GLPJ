import java.util.ArrayList;

/**
 * La classe Database permet de stocker des éléments de divertissements.
 * Une liste de tous les éléments peut être 
 * affichée sur le terminal.
 * 
 * Cette version n'enregistre pas les données sur disque, 
 * et ne fournit aucune fonction de recherche.
 * 
 * @author Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class Database
{
    private ArrayList<Item> items;

    /**
     * Construit une base de données vide.
     */
    public Database()
    {
        items = new ArrayList<Item>();
    }

    /**
     * Ajoute un élément à la base de données.
     * @param theItem L'élément à ajouter.
     */
    public void addItem(Item theItem)
    {
        items.add(theItem);
    }

    /**
     * Affiche une liste de tous les éléments actuellement 
     * stockés sur le terminal.
     */
    public void list()
    {
        for(Item item : items) {
            item.print();
            System.out.println();   // ligne vide entre les éléments
        }
    }
}
