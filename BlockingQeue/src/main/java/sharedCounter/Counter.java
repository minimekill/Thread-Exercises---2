package sharedCounter;

public class Counter {

    private int value;

    public synchronized void inc() {
        int depot = value;
        depot = depot + 1;
        value = depot;
    }
    public int getVal(){
        return value;
    }
}
