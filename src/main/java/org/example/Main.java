package org.example;

import org.example.domain.LinkedList;
import org.example.Menu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList listaProdutos = new LinkedList();

        Menu menu = new Menu(scanner, listaProdutos);
        menu.exibirMenu();

        scanner.close();
    }
}