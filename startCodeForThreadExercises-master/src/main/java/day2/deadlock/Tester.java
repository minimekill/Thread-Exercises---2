package day2.deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Tester {
  
    // A 
    //The program fails because the 2 threads locks the methods and only releases them once their done with both their tasks. meaning they lock each out out of completing.
    //Deadlock discovers that a deadlock has occured!!!
    // i fixed it by putting the release methods earlier so that the arrays doesnt get locked.
    public static void main(String[] args) {
    
        
        
        
    try {
        
      DeadLockDetector dld = new DeadLockDetector();
      dld.start();
        
        
        
      ResourceContainer resources = new ResourceContainer();
      ResourceUser1 t1 = new ResourceUser1(resources);
      ResourceUser2 t2 = new ResourceUser2(resources);
      t1.start();
      t2.start();
          
      t1.join();
      t2.join();
      
      System.out.println("Done");
      System.out.println("Words produced: "+resources.getResourceWords().size());
      System.out.println("Numbers produced: "+resources.getResourceNumbers().size());
    } catch (InterruptedException ex) {
      Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
