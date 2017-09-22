package day2.webscraper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester {
// A Takes time because the new class has to connect to a server and retrieve the document to initiate the document count
// B Simple because we just add "extends Thread" in the TagCounter, and the class already uses a run method wich now just overrides the run.
// C By calling run we do not start a new thread. by starting a new thread the run method will be run wich in this case has been overritten by our method.
// They are empty because the main thread tries to write out without waiting for the threads to actually fill the values we want to write out.
// This is fixed by telling the main thread to wait for the 3 threads to be done, by using the shutdown method in executorservice.
//1,3 s    when running with 4 threads. This is including the main thread
//2,4 s    when running with just one thread
// we were expecting that running the program with threads would be faster as we saw it was. The Computer had 4 processors, in princible one for each thread.
    public static void main(String[] args) {

        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

        long start = System.nanoTime();

       try {
            TagCounter tc1 = new TagCounter("http://www.fck.dk");
    //        tc1.run();
            TagCounter tc2 = new TagCounter("http://www.google.com");
  //          tc2.run();
            TagCounter tc3 = new TagCounter("http://politiken.dk/");
//            tc3.run();
            ExecutorService es = Executors.newCachedThreadPool();
            es.execute(tc1);
            es.execute(tc2);
            es.execute(tc3);
            es.shutdown();
            es.awaitTermination(10, TimeUnit.SECONDS);

            long end = System.nanoTime();
            System.out.println("Time Sequential: " + (end - start));

            System.out.println("Title: " + tc1.getTitle());
            System.out.println("Div's: " + tc1.getDivCount());
            System.out.println("Body's: " + tc1.getBodyCount());

            System.out.println("Title: " + tc2.getTitle());
            System.out.println("Div's: " + tc2.getDivCount());
            System.out.println("Body's: " + tc2.getBodyCount());

            System.out.println("Title: " + tc3.getTitle());
            System.out.println("Div's: " + tc3.getDivCount());
            System.out.println("Body's: " + tc3.getBodyCount());
       } catch (InterruptedException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
