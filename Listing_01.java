public class Listing_01 {

    public static void main(String[] args) {
        Thread t1 = fibonacciThread(40);
        Thread t2 = fibonacciThread(45);
        t1.start();
        System.out.println("1");
        t2.start();
        System.out.println("2");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fertig");
    }

    private static Thread fibonacciThread(int n) {
        return new Thread(() -> {
            System.out.println("Berechne fib(" + n + ")");
            System.out.println("fib(" + n + ") = " + fibonacci(n));
        });
    }

    private static long fibonacci(final int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) +
                fibonacci(n - 2);
    }
}
