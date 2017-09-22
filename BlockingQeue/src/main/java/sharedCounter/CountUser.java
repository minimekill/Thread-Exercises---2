package sharedCounter;

public class CountUser implements Runnable {

    Counter counter;
    int numberOfCounts;

    public CountUser(Counter counter, int numberOfCounts) {
        this.counter = counter;
        this.numberOfCounts = numberOfCounts;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfCounts; i++) {
            counter.inc();

        }

    }

}
