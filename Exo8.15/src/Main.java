public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("John Doe", "123456");
        Student student = new Student("Jane Doe", "654321");

        LabClass labClass = new LabClass(10);

        labClass.enrollStudent(student);
        labClass.setInstructor(teacher);
        labClass.setRoom("A1");
        labClass.setTime("Friday, 10h00");
        labClass.printList();

        student.addCredits(10);
        student.addCredits(20);
        student.addCredits(30);

        student.printCredits();


    }
}