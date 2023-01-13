public class DuplicateKeyException extends Exception {
    private String key;

    public DuplicateKeyException(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "The key '" + key + "' already exists.";
    }
}
