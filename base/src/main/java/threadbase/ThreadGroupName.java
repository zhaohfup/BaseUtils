package threadbase;

/**
 * Created by bst on 2017/9/9.
 */
public class ThreadGroupName implements Runnable {

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName()+"-"+Thread.currentThread().getName();
        while (true){
            System.out.println("i am "+groupAndName);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("group1");
        Thread t1 = new Thread(tg,new ThreadGroupName(),"t1");
        Thread t2 = new Thread(tg,new ThreadGroupName(),"t2");
        t1.setDaemon(true);
        t2.setDaemon(true); //没有守护的就退出，守护的是main线程
        t1.start();
        t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(tg.activeCount());
        tg.list();

    }
}
