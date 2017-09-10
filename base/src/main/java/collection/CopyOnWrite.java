package collection;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bst on 2017/9/5.
 */
public class CopyOnWrite {
    public static void sort() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.addIfAbsent("a"));
        Collections.sort(list);
    }

    public static void main(String[] args) {
        CopyOnWrite.sort();
    }

    public boolean add(String e){
        final ReentrantLock lock = new ReentrantLock();
        lock.lock();
        return false;
    }
}
