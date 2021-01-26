package HomeWork10.Part2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MyThreadPoolImplExtendable implements MyThreadPool {
    private final Queue<Runnable> tasks = new ConcurrentLinkedDeque<>();
    private volatile boolean isRun = true;
    private final int min;
    private final int max;


    public MyThreadPoolImplExtendable(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void start() {
        int tempMin = min;
        int tempMax = max;

        for (int i = 0; i < min; i++) {
            new Thread(new MyThreadPoolImplExtendable.Task()).start();
            if (tasks.size() > min) {
                while (tempMin < tasks.size() && tempMin < max) {
                    new Thread(new MyThreadPoolImplExtendable.Task()).start();
                    tempMin++;
                }
            }
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
                        Thread.sleep(1000);
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
