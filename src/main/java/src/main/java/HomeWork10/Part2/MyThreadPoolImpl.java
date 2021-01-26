package HomeWork10.Part2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;


public class MyThreadPoolImpl implements MyThreadPool {
    private final Queue<Runnable> tasks = new ConcurrentLinkedDeque<>();
    private volatile boolean isRun = true;
    private final int n;

    public MyThreadPoolImpl(int n) {
        this.n = n;
    }

    @Override
    public void start() {
        for (int i = 0; i < n; i++) {
            new Thread(new Task()).start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (isRun) {
            tasks.offer(runnable);
        }
    }

    private final class Task implements Runnable {
        @Override
        public void run() {
            while (isRun) {
                Runnable nextTask = tasks.poll();
                if (nextTask != null) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    nextTask.run();
                }
            }
        }
    }

    public void shutdown() {
        isRun = false;
    }


}
