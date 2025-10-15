package br.edu.fatec.sjc;

public class StackEmptyException extends Exception {
    public StackEmptyException() {
        super("Pilha vazia, impossível remover elemento.");
    }
}
