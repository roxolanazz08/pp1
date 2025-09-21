package FibonacciNumbers;
import java.util.Scanner;

/**
 * Клас Fibonacci представляє число Фібоначчі з його індексом.
 * Також містить метод для перевірки, чи можна число подати у вигляді w²+1.
 */
public class Fibonacci {
    /** Порядковий номер числа Фібоначчі */
    private int index;
    /** Значення числа Фібоначчі */
    private long value;

    /**
     * Конструктор класу Fibonacci.
     *
     * @param index порядковий номер числа Фібоначчі
     * @param value значення числа Фібоначчі
     */
    public Fibonacci(int index, long value){
        this.index=index;
        this.value=value;
    }

    /**
     * Повертає порядковий номер числа Фібоначчі.
     *
     * @return індекс числа
     */
    public int getIndex(){
        return index;
    }

    /**
     * Повертає значення числа Фібоначчі.
     *
     * @return значення числа
     */
    public long getValue(){
        return value;
    }

    /**
     * Перевіряє, чи можна число подати у вигляді w² + 1.
     * @return true, якщо число має вигляд w² + 1, інакше false
     */
    public boolean isSquarePlusOne(){
        if (value>1){
            long w=(long) Math.sqrt(value-1);
            return w * w + 1 == value;
        }
        return false;
    }
}