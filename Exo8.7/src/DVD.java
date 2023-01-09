/**
 * La classe DVD représente un objet DVD. Les informations 
 * concernant le DVD sont stockées et peuvent être récupérées.
 * Nous supposons que nous traitons uniquement ici de DVD de films.
 * 
 * @author Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class DVD extends Item 
{
    private String director;

    /**
     * Constructeur des objets de la classe DVD
     * @param theTitle Le titre du DVD.
     * @param theDirector Le réalisateur du DVD.
     * @param time La durée du DVD.
     */
    public DVD(String theTitle, String theDirector, int time)
    {
        super(theTitle, time);
        director = theDirector;
    }

    /**
     * @return Le réalisateur du DVD.
     */
    public String getDirector()
    {
        return director;
    }
}
