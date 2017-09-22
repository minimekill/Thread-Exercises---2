
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ProducerConsumerSolution {
    public static void main(String[] args) {
        try {
            BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<>();
            
            Producer p = new Producer(sharedQ);
            Consumer c = new Consumer(sharedQ);
            
            c.start();
            p.start();
            p.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProducerConsumerSolution.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
