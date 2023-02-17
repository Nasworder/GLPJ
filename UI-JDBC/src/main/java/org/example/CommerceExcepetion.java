package org.example;

public class CommerceExcepetion extends Exception {
    public CommerceExcepetion(Exception e) {
        super("Commerce exception: " + e.getMessage());
    }
}
