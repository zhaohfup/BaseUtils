package threadbase;

/**
 * Created by bst on 2017/9/9.
 */
public class ThreadInter {
    final static Object obj = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() +" "+ T1.currentThread().getId());
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    System.out.println(T1.currentThread().getId() + " is Interrupted");
                }
                System.out.println(System.currentTimeMillis() + "" + Thread.currentThread().getState());
            }
        }
    }

    public static class T2 extends Thread {
        public void run() {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getId());
                obj.notify();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //等待释放当前对象锁
                System.out.println(Thread.currentThread().getId());
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}
