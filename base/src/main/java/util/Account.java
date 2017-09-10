package util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bst on 2017/9/5.
 */
public class Account {
    private Lock lock = new ReentrantLock();
    private volatile double money;
    public Account(double money){
        this.money=money;
    }
    public void add(){

    }
}
