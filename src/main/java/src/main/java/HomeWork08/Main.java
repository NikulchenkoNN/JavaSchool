package HomeWork08;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Service delegate = new ServiceImpl();
        Service service = (Service) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CachedInvocationHandler(delegate));
        run(service);
    }

    static void run(Service service) {
        System.out.println(service.doHardWork("work1", 10)); //считает результат
        System.out.println(service.doHardWork("work2", 5)); //считает результат
        System.out.println(service.doHardWork("work1", 10)); //результат из кеша
    }
}
