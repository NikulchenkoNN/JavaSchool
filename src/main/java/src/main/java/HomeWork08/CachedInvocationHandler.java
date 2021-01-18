package HomeWork08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
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
        if (!method.isAnnotationPresent(CachedMap.class) || !method.isAnnotationPresent(CachedFile.class)) {
            return method.invoke(delegate, args);
        }
        if (method.isAnnotationPresent(CachedMap.class)) {
            if (!result.containsKey(key(method, args))) {
                System.out.println("Delegation of " + method.getName());
                Object invoke = method.invoke(delegate, args);
                result.put(key(method, args), invoke);
            } else {
                System.out.println("Get data from MAP-cache");
            }
        } else if (method.isAnnotationPresent(CachedFile.class)) {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] str = line.split(" ");


            }
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
