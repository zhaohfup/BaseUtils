package clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by bst on 2017/9/6.
 * 接口信息、成员信息、方法信息、构造方法信息等，根据这些动态获取到的信息创建对象、访问/修改成员、调用方法
 */
public class ClassDemo {
    //获取信息，通过这些信息改造类
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Date> dateClass = Date.class;
        Class<Callable> callableClass = Callable.class;
        Class<Void> voidClass = void.class;
        int[][]arr = new int[2][3];
        Class<? extends int[][]> arrclass = arr.getClass();
        Class<Size> sizeClass = Size.class;
        try {
            Class<?> sizeClass1 = Class.forName("Size");
            System.out.println(sizeClass.getName());
            System.out.println(sizeClass.getSimpleName());
            System.out.println(sizeClass.getCanonicalName());
            System.out.println(sizeClass.getPackage());
            System.out.println(sizeClass.getFields().length);
            System.out.println(sizeClass.getMethods());
            System.out.println(sizeClass.getEnumConstants());//所有枚举常量
            sizeClass.getSimpleName();
            Map<String,String> map = HashMap.class.newInstance();//只能使用默认构造方法
            Constructor<StringBuilder> constructor = StringBuilder.class.getConstructor(new Class[]{int.class});
            StringBuilder stringBuilder = constructor.newInstance(100);
            System.out.println(constructor.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    enum Size{
        SMALL,MEDIUM,BIG;
    }
    public void beforeExecute(Thread t ,Runnable r){
           Field[] fields =  t.getClass().getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);//关闭检查机制
            try {
                field.set(t,null);
                System.out.println(field.getAnnotations());//返回字段的注解
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public static void localClass(){
        //本地类是指在方法内部定义的非匿名内部类
        class MyLocal {
        }
        Runnable r = new Runnable() {
            @Override
            public void run(){

            }
        };
        System.out.println(MyLocal.class.isLocalClass());
        System.out.println(r.getClass().isLocalClass());
    }
}
