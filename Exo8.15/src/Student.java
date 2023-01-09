import java.util.ArrayList;

/**
 * La classe Student représente un étudiant dans un système administratif.
 * Elle contient des informations sur les étudiants.
 * 
 * @author Michael Kolling et David Barnes
 * @version 2008.03.30
 */
public class Student extends Person
{
    // nom complet de l'étudiant

    private int credits;
    private ArrayList<Integer> creditsList;

    /**
     * Crée un nouvel étudiant avec le nom et le numéro d'identité donnés.
     */
    public Student(String fullName, String studentID)
    {
        super(fullName, studentID);
        creditsList = new ArrayList<Integer>();
        credits = 0;
    }



    /**
     * Ajoute des crédits à ceux accumulés par l'étudiant.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
        creditsList.add(additionalPoints);
    }

    /**
     * Renvoie le nombre de crédits accumulés par cet étudiant.
     */
    public int getCredits()
    {
        return credits;
    }


    public void printCredits()
    {
        System.out.print(getName() + ": ");
        for(int i = 0; i < creditsList.size(); i++) {
            if(i == creditsList.size() - 1) {
                System.out.print(creditsList.get(i) + " = ");
            }
            else {
                System.out.print(creditsList.get(i) + " + ");
            }
        }

        System.out.println(credits);
    }
}
