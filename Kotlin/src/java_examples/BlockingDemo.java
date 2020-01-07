package java_examples;

public class BlockingDemo {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("World!");
            } catch (InterruptedException e) { /**/ }
        });
        System.out.print("Hello, ");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) { /**/ }
    }
}
