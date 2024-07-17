package org.example.domain;

public class LinkedList {
    private Node inicio;

    private int tamanho;

    public LinkedList(Node inicio, int size) {
        this.inicio = inicio;
        this.tamanho = size;
    }

    public LinkedList(int tamanho) {
        this.inicio = null;
        this.tamanho = tamanho;
    }

    public Node getInicio() {
        return inicio;
    }

    public void setInicio(Node inicio) {
        this.inicio = inicio;
    }


    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adcionarProduto(Produto produto) {
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
            } else {
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
            }

            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        previousNode.setNext(novoNode);
        tamanho++;
    }


    public String listarProduto() {
        StringBuilder stringBuilder = new StringBuilder();
        Node currentNode = getInicio();

        stringBuilder.append("[");
        while (currentNode.getNext() != null) {
            stringBuilder.append(currentNode.getProduto()).append(", ");
            currentNode = currentNode.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Produto checarExistenciaProduto(String nome) {
        Node currentNode = getInicio();

        while (currentNode.getNext() != null) {
            if (currentNode.getProduto().getNome().equalsIgnoreCase(nome)) {
                return currentNode.getProduto();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

}

