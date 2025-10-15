package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {

    private final CustomStack<T> stack;

    public NumberAscOrder(CustomStack<T> pStack) {
        if (pStack == null) {
            throw new IllegalArgumentException("A CustomStack na inicialização não pode ser nula.");
        }
        this.stack = pStack;
    }


    public List<T> sort() {
        List<T> sortedList = new ArrayList<>();

        while (!stack.isEmpty()) {
            try {
                sortedList.add(stack.pop());
            } catch (StackEmptyException e) {
                throw new RuntimeException("Erro inesperado ao tentar desempilhar um elemento: " + e.getMessage(), e);
            }
        }
        
        Collections.sort(sortedList);

        return sortedList;
    }
}