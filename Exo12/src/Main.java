public class Main {
    public static void main(String[] args) {
        AddressBookDemo demo = new AddressBookDemo();


        AddressBookTextInterface interaction = new AddressBookTextInterface(demo.getBook());
        interaction.run();

    }
}