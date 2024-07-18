package org.example.domain;

import org.example.exception.NodeNotFoundException;
import org.example.exception.ProdutoNotFoundException;

public class LinkedList {
    private Node inicio;
    private int tamanho;

    public LinkedList(Node inicio, int tamanho) {
        this.inicio = inicio;
        this.tamanho = tamanho;
    }

    public LinkedList(int tamanho) {
        this.inicio = null;
        this.tamanho = tamanho;
    }

    public LinkedList() {
        this.inicio = null;
        this.tamanho = 0;
    }

    protected Node getInicio() {
        return inicio;
    }

    protected void setInicio(Node inicio) {
        this.inicio = inicio;
    }

    protected int getTamanho() {
        return tamanho;
    }

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionarProduto(Produto produto) {
        Node novoNode = new Node(produto);

        if (inicio == null) {
            inicio = novoNode;
            tamanho++;
            return;
        }

        Node currentNode = inicio;
        Node previousNode = null;

        while (currentNode != null) {
            Produto produtoAtual = currentNode.getProduto();

            if (produto.equals(produtoAtual)) {
                produtoAtual.setQuantidade(produtoAtual.getQuantidade() + produto.getQuantidade());
                return;
            }

            int compare = produto.getNome().compareToIgnoreCase(produtoAtual.getNome());
            if (compare < 0) {
                novoNode.setNext(currentNode);
                if (previousNode == null) {
                    inicio = novoNode;
                } else {
                    previousNode.setNext(novoNode);
                }
                tamanho++;
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        previousNode.setNext(novoNode);
        tamanho++;
    }

    public String listarProdutos() {
        StringBuilder stringBuilder = new StringBuilder();
        Node currentNode = getInicio();

        stringBuilder.append("[");
        while (currentNode != null) {
            stringBuilder.append(currentNode.getProduto());
            currentNode = currentNode.getNext();
            if (currentNode != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Produto checarExistenciaProduto(String nome) {
        try {
            Node node = acharNodePorNomeDeProduto(nome);
            return node.getProduto();
        } catch (NodeNotFoundException e) {
            throw new ProdutoNotFoundException("Não foi possível encontrar um produto com esse nome.");
        }
    }

    public void retirarProduto(String nomeProduto) {
        Node currentNode = inicio;
        Node previousNode = null;

        while (currentNode != null && !currentNode.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            throw new ProdutoNotFoundException("Produto não encontrado.");
        }

        Produto produto = currentNode.getProduto();

        RemoverProduto(produto, previousNode, currentNode);
    }

    private void RemoverProduto(Produto produto, Node previousNode, Node currentNode) {
        if (produto.getQuantidade() > 1) {
            produto.setQuantidade(produto.getQuantidade() - 1);
        } else {
            if (previousNode == null) {
                inicio = currentNode.getNext();
            } else {
                previousNode.setNext(currentNode.getNext());
            }
            tamanho--;
        }
    }

    private Node acharNodePorNomeDeProduto(String nome) throws NodeNotFoundException {
        Node currentNode = getInicio();

        while (currentNode != null) {
            if (currentNode.getProduto().getNome().equalsIgnoreCase(nome)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        throw new NodeNotFoundException("Node não encontrado.");
    }
}
