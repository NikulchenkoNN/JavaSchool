package HomeWork11;

import java.util.concurrent.Callable;

public class Task<T> {
    private final Callable<? extends T> callable;
    private volatile T temp;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws Exception {
        if (temp == null) {
            synchronized (callable) {
                if (temp == null) {
                    Thread.currentThread().sleep(500);
                    temp = callable.call();
                    System.out.println("Thread sleep");
                    Thread.currentThread().sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }

        return temp;
    }

    public Callable<? extends T> getCallable() {
        return callable;
    }
}
