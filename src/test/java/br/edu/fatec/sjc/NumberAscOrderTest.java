package br.edu.fatec.sjc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    @Mock
    private CustomStack<Integer> customStackMock;

    @InjectMocks
    private NumberAscOrder<Integer> numberAscOrder;

    @Test
    void sort_FullStackWithRandomNumbers_ShouldReturnAscendingList() throws StackEmptyException {
        when(customStackMock.isEmpty())
            .thenReturn(false) 
            .thenReturn(false) 
            .thenReturn(false) 
            .thenReturn(false) 
            .thenReturn(false) 
            .thenReturn(false) 
            .thenReturn(true);  
     
        when(customStackMock.pop())
            .thenReturn(50) 
            .thenReturn(10)
            .thenReturn(90)
            .thenReturn(30)
            .thenReturn(70)
            .thenReturn(20); 

        List<Integer> result = numberAscOrder.sort();

        List<Integer> expected = Arrays.asList(10, 20, 30, 50, 70, 90);

        assertEquals(expected.size(), result.size(), "O tamanho da lista deve ser 6.");
        assertEquals(expected, result, "A lista deve estar ordenada em ordem crescente.");
       
        verify(customStackMock, times(6)).pop();
    
        verify(customStackMock, times(7)).isEmpty();

        verifyNoMoreInteractions(customStackMock);
    }

    @Test
    void sort_EmptyStack_ShouldReturnEmptyList() throws StackEmptyException {
        when(customStackMock.isEmpty()).thenReturn(true);

        List<Integer> result = numberAscOrder.sort();

        assertTrue(result.isEmpty(), "A lista resultante deve ser vazia.");

        verify(customStackMock, never()).pop();

        verify(customStackMock, times(1)).isEmpty();
    }

    @Test
    void sort_SingleElementStack_ShouldReturnListWithOneElement() throws StackEmptyException {
        when(customStackMock.isEmpty())
            .thenReturn(false) 
            .thenReturn(true); 

        when(customStackMock.pop()).thenReturn(15);

        List<Integer> result = numberAscOrder.sort();

        assertEquals(1, result.size());
        assertEquals(15, result.get(0));
        verify(customStackMock, times(1)).pop();
    }
}