package HomeWork08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class CachedInvocationHandler implements InvocationHandler {
    private final Object delegate;
    private Map<String, Object> result ;
    private String file;

    public static <T> T cache(Object delegate) {
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CachedInvocationHandler(delegate));
    }

    public CachedInvocationHandler(Object delegate) {
        this.delegate = delegate;
        result = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(delegate, args);
        }
        file = method.getAnnotation(Cache.class).fileName();
        Sources source = method.getAnnotation(Cache.class).source();
        if (source.equals(Sources.FILE)) {
            result = ReadData.reader(file);
        }
        if (!result.containsKey(args[0])) {
            System.out.println("Delegation of " + method.getName());
            Object invoke = method.invoke(delegate, args);
            result.put((String) args[0], invoke);
        }
        if (source.equals(Sources.FILE)) {
            SaveData.saver(result, file);
        }
        return result.get(args[0]);
    }


}
