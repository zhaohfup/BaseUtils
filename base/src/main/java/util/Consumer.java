package util;

/**
 * Created by bst on 2017/9/4.
 */
public class Consumer extends Thread {
    MyBlockingQueue<String> queue;

    public Consumer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String task = queue.take();
                System.out.println("handle task " + task);
                Thread.sleep((int) (Math.random() * 100));
            }
        } catch (InterruptedException e) {
        }
    }


    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<String>(10);
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
