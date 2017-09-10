package task;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by bst on 2017/9/5.
 */
public class TaskDemo {
    /**
     * Runnable和Callable：表示要执行的异步任务
     * Executor和ExecutorService：表示执行服务
     * Future：表示异步任务的结果
     */
    static class Task implements Callable {
        @Override
        public Object call() throws Exception {
            int random = new Random().nextInt(1000);
            Thread.sleep(random);
            return random;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Task());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(future.get());//阻塞等待结果，可以设定阻塞时间
        executorService.shutdown();
    }
}
