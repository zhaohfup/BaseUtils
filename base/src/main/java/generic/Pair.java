package generic;

/**
 * Created by bst on 2017/9/6.
 * 类、接口、方法都可以是泛型的.类型参数
 */
public class Pair<T> {
    T first;
    T second;
    private static Pair ourInstance = new Pair();

    public static Pair getInstance() {
        return ourInstance;
    }

    private Pair() {
    }
}
