package HomeWork08;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class CachedInvocationHandler implements InvocationHandler {
    private final Object delegate;
    private final Map<Object, Object> result = new HashMap<>();
    private final File file = new File("D:/cache.txt");

    public static <T> T cache(Object delegate) {
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CachedInvocationHandler(delegate));
    }

    public CachedInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(delegate, args);
        }
        if (!result.containsKey(key(method,args))) {
            System.out.println("Delegation of " + method.getName());
            Object invoke = method.invoke(delegate, args);
            result.put(key(method, args), invoke);
        } else {
            System.out.println("Get data from cache");
        }
        return result.get(key(method, args));
    }

    private Object key(Method method, Object[] args) {
        List<Object> key = new ArrayList<>();
        key.add(method);
        key.addAll(Arrays.asList(args));
        return key;
    }
}
