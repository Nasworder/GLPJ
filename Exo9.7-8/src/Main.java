public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        CD cd1 = new CD("A Swingin' Affair", "Frank Sinatra", 16, 64);
        cd1.setOwn(true);
        cd1.setComment("my favourite Sinatra album");
        db.addItem(cd1);
        db.list();



    }
}