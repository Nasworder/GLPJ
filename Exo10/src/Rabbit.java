import java.util.List;
import java.util.Random;

/**
 * Un modèle simple de lapin (rabbit).
 * Un lapin vieillit, se déplace, se reproduit et meurt.
 * 
 * @author David J. Barnes et Michael Kolling
 * @version 2008.03.30
 */
public class Rabbit extends Animal implements Drawable
{
    // Caractéristiques partagées par tous les lapins (champs statiques).

    // L'âge à partir duquel un lapin peut se reproduire.
    private static final int BREEDING_AGE = 5;
    // L'âge maximal d'un lapin.
    private static final int MAX_AGE = 40;
    // La probabilité de reproduction d'un lapin.
    private static final double BREEDING_PROBABILITY = 0.15;
    // La taille maximale d'une portée.
    private static final int MAX_LITTER_SIZE = 4;



    /**
     * Crée un lapin. Un lapin peut être créé comme nouveau-né (âge nul)
     * ou avec un âge aléatoire.
     * 
     * @param randomAge Si true, le lapin aura un âge aléatoire.
     * @param field Le terrain actuellement occupé.
     * @param location L'emplacement sur le terrain.
     */
    public Rabbit(boolean randomAge, Field field, Location location)
    {
        super(randomAge,field, location);


    }
    
    /**
     * Ce que fait un lapin la plupart du temps : il se déplace.
     * Il peut se reproduire ou mourir de vieillesse.
     * @param newRabbits Une liste à laquelle ajouter les nouveau-nés.
     */
    public void act(List<Actor> newRabbits)
    {
        incrementAge();
        if(alive) {
            giveBirth(newRabbits);            
            // Essaie de passer à un nouvel emplacement.
            Location newLocation = field.freeAdjacentLocation(location);
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Surpopulation.
                setDead();
            }
        }
    }
    


    
    /**
     * Vérifie si ce lapin va donner naissance.
     * Les nouveau-nés seront placés dans des sites adjacents libres.
     * @param newRabbits Une liste pour ajouter les nouveau-nés.
     */
    private void giveBirth(List<Actor> newRabbits)
    {
        // Nouveau-nés placés dans des sites adjacents.
        // Obtenir une liste des emplacements adjacents libres.
        List<Location> free = field.getFreeAdjacentLocations(location);
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Rabbit young = new Rabbit(false, field, loc);
            newRabbits.add(young);
        }
    }

    protected int getBreedingAge()
    {
        return BREEDING_AGE;
    }

    protected int getMaxAge()
    {
        return MAX_AGE;
    }

    protected double getBreedingProbability()
    {
        return BREEDING_PROBABILITY;
    }

    protected int getMaxLitterSize()
    {
        return MAX_LITTER_SIZE;
    }



}
