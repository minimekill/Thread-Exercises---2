package sharedCounter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {

    public static void main(String[] args) {
        try {
            Counter counter = new Counter();
            
            int numberOfCounts = 50000;
            
            CountUser cu1 = new CountUser(counter, numberOfCounts);
            Thread t1 = new Thread(cu1);
            CountUser cu2 = new CountUser(counter, numberOfCounts);
            Thread t2 = new Thread(cu2);
            CountUser cu3 = new CountUser(counter, numberOfCounts);
            Thread t3 = new Thread(cu3);
            CountUser cu4 = new CountUser(counter, numberOfCounts);
            Thread t4 = new Thread(cu4);
            CountUser cu5 = new CountUser(counter, numberOfCounts);
            Thread t5 = new Thread(cu5);
            CountUser cu6 = new CountUser(counter, numberOfCounts);
            
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            
            System.out.println("Result " + counter.getVal());
        } catch (InterruptedException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
