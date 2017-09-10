package classloader;

/**
 * Created by bst on 2017/9/7.
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        //双亲委派，BootstrapLoader为null
        while (classLoader!=null){
            System.out.println(classLoader.getClass().getName());
            classLoader = classLoader.getParent();
        }
        System.out.println(String.class.getClassLoader());
    }
}
