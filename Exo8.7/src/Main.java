public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Database db = new Database();
        db.addItem(new VideoGame("Super Mario Bros", 60, 2, "NES"));
        db.addItem(new VideoGame("Super Mario Bros 2", 60, 2, "NES"));
        db.addItem(new VideoGame("Super Mario Bros 3", 60, 2, "NES"));
        db.addItem(new VideoGame("Super Mario World", 60, 2, "SNES"));
        db.addItem(new VideoGame("Super Mario 64", 60, 2, "N64"));

        db.list();


    }
}