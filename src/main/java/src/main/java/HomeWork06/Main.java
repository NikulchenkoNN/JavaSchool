package HomeWork06;

import java.lang.reflect.*;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Calculator delegate = new CalculatorImpl();
        Calculator calculator = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CachedInvocationHandler(delegate));
        run(calculator);


        Calculator calculator1 = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new PerformanceProxy(delegate));
        run(calculator1);

        //Task 2
        Method[] methods = CalculatorImpl.class.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        //Task 3
        for (Method m : methods) {
            if (m.toString().toLowerCase(Locale.ROOT).contains("get"))
                System.out.println(m);
        }

        //Task 4
        Field[] declaredFields = CalculatorImpl.class.getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            if (f.toString().contains("String")) {
                String[] split = f.toString().split("\\.");
                String s = split[split.length - 1];
                System.out.println(s.equals(f.get(delegate)));
            }

        }

    }


    private static void run(Calculator calculator) {
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(5));
        System.out.println(calculator.calc(6));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));

    }
}
