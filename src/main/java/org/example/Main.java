package org.example;


import org.example.domain.LinkedList;
import org.example.domain.Produto;

public class Main {

    public static void main(String[] args) {
        Produto p1 = new Produto("Tomate", 0);
        Produto p2 = new Produto("Acerola", 1);
        Produto p3 = new Produto("Maça", 10);
        Produto p4 = new Produto("Banana", 22);
        Produto p5 = new Produto("Goiaba", 3);

        LinkedList list = new LinkedList();

        list.adicionarProduto(p1);
        list.adicionarProduto(p2);
        list.adicionarProduto(p3);
        list.adicionarProduto(p4);
        list.adicionarProduto(p5);

        System.out.println(list.listarProdutos());

        list.adicionarProduto(new Produto("Tomate", 1));

        System.out.println(list.checarExistenciaProduto("Tomate"));

        list.retirarProduto("Banana");
        System.out.println(list.checarExistenciaProduto("Banana"));
        list.retirarProduto("Tomate");
        System.out.println(list.listarProdutos());

    }
}