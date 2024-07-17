package org.example.domain;

public class Node {
    private Node next;
    private Produto produto;

    public Node() {
    }

    public Node(Produto produto) {
        this.next = null;
        this.produto = produto;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
