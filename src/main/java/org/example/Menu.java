package org.example;

import org.example.domain.LinkedList;
import org.example.domain.Produto;
import org.example.exception.ProdutoNotFoundException;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private LinkedList listaProdutos;

    public Menu(Scanner scanner, LinkedList listaProdutos) {
        this.scanner = scanner;
        this.listaProdutos = listaProdutos;
    }

    public void exibirMenu() {
        int escolha = 0;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Remover Produto");
            System.out.println("4 - Checar Existência do Produto");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    checarExistenciaProduto();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (escolha != 5);
    }

    private void adicionarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer após o nextInt()

        Produto produto = new Produto(nome, quantidade);
        listaProdutos.adicionarProduto(produto);

        System.out.println("Produto adicionado com sucesso.");
    }

    private void listarProdutos() {
        System.out.println("\nLista de Produtos:");
        System.out.println(listaProdutos.listarProdutos());
    }

    private void removerProduto() {
        System.out.print("Digite o nome do produto a ser removido: ");
        String nome = scanner.nextLine();

        try {
            listaProdutos.retirarProduto(nome);
            System.out.println("Produto removido com sucesso.");
        } catch (ProdutoNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checarExistenciaProduto() {
        System.out.print("Digite o nome do produto a ser verificado: ");
        String nome = scanner.nextLine();

        try {
            Produto produto = listaProdutos.checarExistenciaProduto(nome);
            System.out.println("Produto encontrado: " + produto);
        } catch (ProdutoNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
