package exampleday2;

public class QuickDemo extends Thread {

    public static int COUNT_TIMES = 5;

    @Override
    public void run() {
        int counter = 0;
        while (counter < COUNT_TIMES) {
            System.out.println("Hello Class");
            counter++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public static void main(String[] args) {
        QuickDemo qd = new QuickDemo();
        qd.start(); //What is printed first, and what is wrong here
        
        System.out.println("#### Hello World ####");
    }
}
