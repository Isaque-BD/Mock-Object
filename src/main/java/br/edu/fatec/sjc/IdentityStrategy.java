package br.edu.fatec.sjc;

public class IdentityStrategy<T extends Number> implements CalculableStrategy<T> {
    @Override
    public T calculateValue(T element) {
        return element; 
    }
}