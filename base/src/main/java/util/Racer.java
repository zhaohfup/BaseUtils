package util;

/**
 * Created by bst on 2017/9/4.
 */
public class Racer extends Thread {
    FireFlag fireFlag;

    public Racer(FireFlag fireFlag) {
        this.fireFlag = fireFlag;
    }

    @Override
    public void run() {
        try {
            this.fireFlag.waitForFire();
            System.out.println("start run "
                    + Thread.currentThread().getName());
        } catch (InterruptedException e) {
        }
    }

    //每个子线程启动后等待fire信号，主线程调用fire()后各个子线程才开始执行后续操作。
    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        FireFlag fireFlag = new FireFlag();
        Thread[] racers = new Thread[num];
        for (int i = 0; i < num; i++) {
            racers[i] = new Racer(fireFlag);
            racers[i].start();
        }
        Thread.sleep(1000);
        fireFlag.fire();
    }
}
