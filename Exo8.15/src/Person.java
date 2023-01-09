public class Person {

    private String name;
    // numéro d'identité de l'étudiant
    private String id;
    // nombre de crédits obtenus jusqu'à présent

    public Person(String fullName, String id)
    {
        name = fullName;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    public String getID()
    {
        return id;
    }

    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }

    public void print()
    {
        System.out.println(name + " (" + id + ")");
    }
}
