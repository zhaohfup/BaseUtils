package mulThreadModel;

/**
 * Created by bst on 2017/9/10.
 */
public class Gate {
    private int counter = 0;
    private String name = "nobody";
    private String address = "nowhere";

    /**
     * 1 对给定对象加锁，进入同步代码块前要获得给定对象的锁
     * 2 直接作用域实例方法
     * 3 直接作用于静态方法
     * 4 每一个Object都有锁和2个等待队列
     * 5 可以使用显示锁ReenterLock
     * 6 volatile虽然能保证可见性但对复合操作是线程不安全
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***broken***" + toString());
        } else {
            System.out.println(counter);
        }
    }

    public synchronized String toString() {
        return "NO." + counter + ":" + name + "," + address;
    }

    static class UserThread extends Thread {
        private Gate gate;
        private String name;
        private String address;

        public UserThread(Gate gate, String name1, String address) {
            this.gate = gate;
            this.name = name1;
            this.address = address;
        }

        public void run() {
            System.out.println(name + " begin");
            while (true) {
                gate.pass(name, address);
            }
        }
    }

    public static void main(String[] args) {
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "baby", "baby").start();
        new UserThread(gate, "chris", "china").start();
    }
}
