package org.example.exception;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(String msg) {
        super(msg);
    }
}
