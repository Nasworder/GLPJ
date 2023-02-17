package org.example;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(int numItem) {
        super("Item "+numItem+" inexistant ou déjà vendu");
    }
}
