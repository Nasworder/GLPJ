public class Game extends Item {
    private int numberOfPlayers;

    public Game(String theTitle, int time, int players) {
        super(theTitle, time);
        numberOfPlayers = players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }


}
