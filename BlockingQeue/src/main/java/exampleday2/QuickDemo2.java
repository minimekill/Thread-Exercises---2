

package exampleday2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuickDemo2 {

    public static void main(String[] args) {
        try {
            Callable<String> c1 = () -> "lol";
            Callable<String> c2 = () -> {
                
                String s = "";
                for (int i = 0; i < 10; i++) {
                    s += i;
                    
                }
                return s;
            };
            
            ExecutorService ex = Executors.newCachedThreadPool();
            Future<String> f1 = ex.submit(c1);
            Future<String> f2 = ex.submit(c2);
            
            System.out.println(f1.get());
            System.out.println(f2.get());
            
            
        } catch (InterruptedException | ExecutionException ex1) {
            Logger.getLogger(QuickDemo2.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        
    }

}