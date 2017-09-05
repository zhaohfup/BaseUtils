package util;

/**
 * Created by bst on 2017/9/4.
 */
public class Switcher {
    //加了volatile之后，Java会在操作对应变量时插入特殊的指令，保证读写到内存最新值，而非缓存的值
    public volatile boolean on;

    public boolean isOn(){
        return  on;
    }
    public void setOn(boolean on){
        this.on = on;
    }
}
