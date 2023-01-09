import java.util.*;

/**
 * La classe LabClass représente une liste d'inscriptions pour une séance de TP. Elle contient
 * l'heure, la salle et les participants, ainsi que le nom de l'enseignant.
 * 
 * @author Michael Kolling et David Barnes
 * @version 2008.03.30
 */
public class LabClass
{
    private Teacher instructor;
    private String room;
    private String timeAndDay;
    private List<Student> students;
    private int capacity;
    
    /**
     * Crée un LabClass avec un nombre maximum d'inscriptions. Tous les autres détails
     * sont définis sur les valeurs par défaut.
     */
    public LabClass(int maxNumberOfStudents)
    {
        instructor = new Teacher("inconu", "0");
        room = "inconnu";
        timeAndDay = "inconnu";
        students = new ArrayList<Student>();
        capacity = maxNumberOfStudents;
    }

    /**
     * Ajoute un étudiant à cette LabClass.
     */
    public void enrollStudent(Student newStudent)
    {
        if(students.size() == capacity) {
            System.out.println("La classe est pleine, vous ne pouvez plus vous inscrire.");
        }
        else {
            students.add(newStudent);
        }
    }
    
    /**
     * Renvoie le nombre d'étudiants actuellement inscrits dans cette LabClass.
     */
    public int numberOfStudents()
    {
        return students.size();
    }
    
    /**
     * Définit le numéro de salle pour cette LabClass.
     */
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }
    
    /**
     * Définit l'heure de cette LabClass. Le paramètre doit définir le jour
     * et l'heure, comme "vendredi, 10h00".
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }
    
    /**
     * Définit le nom de l'instructeur pour cette LabClass.
     */
    public void setInstructor(Teacher teacher)
    {
        instructor = teacher;
    }
    
    /**
     * Affiche une liste de la classe avec d'autres infos sur LabClass sur le
     * terminal standard.
     */
    public void printList()
    {
        System.out.println("TP " + timeAndDay);
        System.out.println("Instructeur : " + instructor.getName() + "   salle : " + room);
        System.out.println("Liste de la classe :");
        for(Student student : students) {
            student.print();
        }
        System.out.println("Nombre d'étudiants : " + numberOfStudents());
    }
}
