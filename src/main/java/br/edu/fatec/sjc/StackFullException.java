package br.edu.fatec.sjc;

public class StackFullException extends Exception {
    public StackFullException() {
        super("Pilha cheia, limite atingido.");
    }
}
