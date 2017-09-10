package collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bst on 2017/9/5.2
 */
public class ConcurrentHashMapIteratorDemo {
    //如果变化发生在已遍历过的部分，迭代器就不会反映出来，而如果变化发生在未遍历过的部分，迭代器就会发现并反映出来，这就是弱一致性
    public static void test() {
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("a", "a1");
        map.put("b", "b1");
        Thread t1 = new Thread() {
            public void run() {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
            }
        };

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put("c", "c1");

    }

    public static void main(String[] args) {
        test();
    }
}
