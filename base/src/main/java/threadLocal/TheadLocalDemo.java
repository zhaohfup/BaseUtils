package threadLocal;

/**
 * Created by bst on 2017/9/6.
 */
public class TheadLocalDemo {
    static ThreadLocal<Integer> local = new ThreadLocal<Integer>();

    //每个线程都有一个Map，对于每个ThreadLocal对象，调用其get/set实际上就是以ThreadLocal对象为键读写当前线程的Map，这样，就实现了每个线程都有自己的独立拷贝的效果。
    //每个线程都不会相互影响，因为每个线程都有独立的值
    public static void main(String[] args) {
        //ThreadLocalRandom random = ThreadLocalRandom.current();
        ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
        threadLocal.set(1);
        System.out.println(threadLocal.get());
        Thread child = new Thread() {
            public void run() {
                System.out.println(local.get());
                local.set(100);
                System.out.println(local.get());
            }
        };
        local.set(200);
        child.start();
        try {
            child.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(local.get());

    }
}
