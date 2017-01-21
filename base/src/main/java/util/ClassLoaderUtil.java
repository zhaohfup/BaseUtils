package util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * 类加载器
 * Created by bst on 2017/1/21.
 */
public class ClassLoaderUtil {
    private static final Logger logger = LoggerFactory.getLogger(ClassLoaderUtil.class);

    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className, boolean init) {
        Class<?> cls = null;

        try {
            cls = Class.forName(className, init, getClassLoader());
        } catch (ClassNotFoundException e) {
            logger.error("loadClass is error", e);
            e.printStackTrace();
        }
        return cls;
    }

    public static Set<Class<?>> getClassSet(String packageName) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try {
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if (url!=null){
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")){

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classSet;
    }
}
