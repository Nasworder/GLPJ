public class VideoGame extends Game {
    private String platform;

    public VideoGame(String theTitle, int time, int players, String platform) {
        super(theTitle, time, players);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }




}
