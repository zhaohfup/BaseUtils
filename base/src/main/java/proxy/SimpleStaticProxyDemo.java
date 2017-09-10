package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by bst on 2017/9/6.
 */
public class SimpleStaticProxyDemo {
    static interface IService{
        public void sayHello();
    }
    static class RealService implements IService{

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }
    static class ProxyService implements IService{
        private IService iService;
        public ProxyService(IService iService){
            this.iService=iService;
        }
        @Override
        public void sayHello() {
            this.iService.sayHello();
        }
    }
    static class SimpleInvocationHandler implements InvocationHandler {
        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }public static void main(String[] args) {
        IService realService = new RealService();
        IService proxyService = new ProxyService(realService);
        proxyService.sayHello();
        IService proxyService1 = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class<?>[] { IService.class }, new SimpleInvocationHandler(realService));
        proxyService.sayHello();
    }
}
