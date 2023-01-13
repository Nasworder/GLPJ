public class NoMatchingDetailsException extends Exception {

    private String key;

    public NoMatchingDetailsException(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "No details matching '" + key + "' were found.";
    }
}
