package HomeWork10.Part2;

public interface MyThreadPool {
    void start() throws InterruptedException;
    void execute(Runnable runnable);
}
