package org.example.exception;

public class NodeNotFoundException extends RuntimeException {
    public NodeNotFoundException(String msg) {
        super(msg);
    }
}
