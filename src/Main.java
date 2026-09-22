public class Main {
    public static void main(String[] args) {
        greet("Kishore");

        System.out.println("Sum: " + add(10, 20));
        System.out.println("Is 7 even? " + isEven(7));
        System.out.println("Is 10 even? " + isEven(10));
        System.out.println("Largest number: " + findLargest(12, 25));
        System.out.println("5 factorial: " + factorial(5));

        System.out.print("Prime numbers from 0 to 100: ");
        printPrimes(100);
        printPrimes(200);
        printPrimes(300);
        printPrimes(400);


    }

    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    static int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    static int findLargest(int firstNumber, int secondNumber) {
        return Math.max(firstNumber, secondNumber);
    }

    static long factorial(int number) {
        long result = 1;

        for (int i = 2; i <= number; i++) {
            result *= i;
        }

        return result;
    }

    static void printPrimes(int limit) {
        for (int number = 0; number <= limit; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}