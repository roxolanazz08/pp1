package FibonacciNumbers;
import java.util.Scanner;

/**
 * Головний клас програми для роботи з числами Фібоначчі.
 * <p>
 * Програма генерує перші N чисел Фібоначчі та виводить їх на екран.
 * Додатково перевіряє, які з них можна подати у вигляді w² + 1.
 */
public class Main {

    /**
     * Обчислює n-те число Фібоначчі.
     * <p>
     *
     * @param n порядковий номер числа Фібоначчі (починаючи з 1)
     * @return значення n-го числа Фібоначчі
     */
    public static long getFibonacci(int n){
        if (n==1 || n==2)
            return 1;

        long a=1, b=1;
        for (int i=3; i<=n; i++){
            long c=a+b;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * Точка входу в програму.
     * <p>
     * Зчитує кількість чисел N з аргументів командного рядка або з консолі.
     * Створює масив об'єктів {@link Fibonacci}, виводить усі числа Фібоначчі
     * та окремо показує ті, що мають вигляд w² + 1.
     *
     * @param args аргументи командного рядка (опціонально містять N)
     */
    public static void main(String[] args){
        int N;
        if (args.length > 0) {
            N = Integer.parseInt(args[0]);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введіть кількість чисел N: ");
            N=sc.nextInt();
        }
        // Генерація чисел Фібоначчі та збереження їх у масиві
        Fibonacci[] numbers = new Fibonacci[N];

        for (int i = 0; i < N; i++){
            long value = getFibonacci(i+1);
            numbers[i] = new Fibonacci(i+1, value);
        }

        // Вивід усіх чисел Фібоначчі
        System.out.println("Числа Фібоначчі: ");
        for (Fibonacci num : numbers){
            System.out.println(num.getIndex() + ": " + num.getValue());
        }


        // Вивід чисел виду w^2+1
        System.out.println("Числа виду w^2+1: ");
        boolean found = false;
        for (Fibonacci f : numbers) {
            if (f.isSquarePlusOne()) {
                System.out.println(f.getValue());
                found = true;
            }
        }

        if (!found){
            System.out.println("Таких чисел немає!");
        }
    }
}
