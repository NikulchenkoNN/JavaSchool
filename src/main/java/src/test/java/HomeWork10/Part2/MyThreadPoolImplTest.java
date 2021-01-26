package HomeWork10.Part2;


import HomeWork10.Part1.ThreadClass;
import org.junit.Test;

public class MyThreadPoolImplTest {

    @Test
    public void tester() throws InterruptedException {
        MyThreadPoolImpl threadPool = new MyThreadPoolImpl(5);

        threadPool.execute(new ThreadClass(8));
        threadPool.execute(new ThreadClass(15));
        threadPool.execute(new ThreadClass(25));
        threadPool.execute(new ThreadClass(8));
        threadPool.execute(new ThreadClass(16));
        threadPool.execute(new ThreadClass(100));
        threadPool.start();
        Thread.sleep(20000);
    }

    @Test
    public synchronized void tester2() throws InterruptedException {
        MyThreadPoolImplExtendable threadPoolExtendable = new MyThreadPoolImplExtendable(1, 2);
        threadPoolExtendable.execute(new ThreadClass(5));
        threadPoolExtendable.execute(new ThreadClass(4));
        threadPoolExtendable.execute(new ThreadClass(8));
        threadPoolExtendable.execute(new ThreadClass(10));
        threadPoolExtendable.execute(new ThreadClass(15));
        threadPoolExtendable.execute(new ThreadClass(25));
        threadPoolExtendable.execute(new ThreadClass(30));
        threadPoolExtendable.execute(new ThreadClass(75));
        threadPoolExtendable.execute(new ThreadClass(42));
        threadPoolExtendable.execute(new ThreadClass(32));
        threadPoolExtendable.execute(new ThreadClass(1));
        threadPoolExtendable.execute(new ThreadClass(75));
        threadPoolExtendable.execute(new ThreadClass(75));
        threadPoolExtendable.execute(new ThreadClass(75));

        threadPoolExtendable.start();
        Thread.sleep(20000);
    }
}