package HomeWork07;

import HomeWork08.CachedInvocationHandler;
import HomeWork08.Service;
import HomeWork08.ServiceImpl;

public class Main {
    public static void main(String[] args) {
        Service service = CachedInvocationHandler.cache(new ServiceImpl());
        System.out.println(service.doHardWork("work1", 10));
    }

}
