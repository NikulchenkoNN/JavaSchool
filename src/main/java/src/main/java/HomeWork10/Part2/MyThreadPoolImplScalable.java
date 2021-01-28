package HomeWork10.Part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MyThreadPoolImplScalable implements MyThreadPool {
    private final int max;
    private final int min;
    private volatile boolean isRun = true;
    private final Queue<Runnable> taskQueue = new ConcurrentLinkedDeque<>();
    private final List<Thread> threadList = new ArrayList<>();

    public MyThreadPoolImplScalable(int min, int max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public void start() {
        synchronized (threadList) {
            for (int i = 0; i < min; i++) {
                addThread();
            }
            System.out.println("start threads");
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (taskQueue) {
            if (isRun) {
                taskQueue.offer(runnable);
                System.out.println("add task");
                taskQueue.notify();
                System.out.println("notify threads about task");
                if (taskQueue.size() > threadList.size() && threadList.size() < max) {
                    addThread();
                }
            }
        }
    }

    private class ThreadClass extends Thread {
        public void run() {
            Runnable nextTask;
            while (isRun) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    nextTask = taskQueue.poll();
                    System.out.println("take task");
                    nextTask.run();
                    System.out.println("start task");
                }
            }
        }
    }

    public void shutdown() {
        isRun = false;
    }

    public void addThread() {
        ThreadClass thread = new ThreadClass();
        threadList.add(thread);
        thread.start();
    }
}
