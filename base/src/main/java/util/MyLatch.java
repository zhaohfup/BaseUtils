package util;

/**
 * Created by bst on 2017/9/4.
 */
public class MyLatch {
    private int count;

    public MyLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait();
        }
    }

    public synchronized void countDown() {
        count--;
        System.out.println("count="+count);
        if (count <= 0) {
            notifyAll();
        }
    }
}
