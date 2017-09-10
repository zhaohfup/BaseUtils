package collection;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by bst on 2017/9/5.
 */
public class SkipMap {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentSkipListMap<String, String>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        System.out.println(map.toString());

    }
}
