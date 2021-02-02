package HomeWork10;


import HomeWork10.Part1.ThreadClass;
import HomeWork10.Part2.MyThreadPoolImpl;
import HomeWork10.Part2.MyThreadPoolImplScalable;
import org.junit.Test;

import java.io.IOException;

public class FIleReadToListTest {

    @Test
    public void tester() throws InterruptedException {
        MyThreadPoolImpl threadPool = new MyThreadPoolImpl(10);
        threadPool.start();
        threadPool.execute(new ThreadClass(8));
        threadPool.execute(new ThreadClass(15));
        threadPool.execute(new ThreadClass(75));
        threadPool.execute(new ThreadClass(8));
        threadPool.execute(new ThreadClass(16));
        threadPool.execute(new ThreadClass(100));

        Thread.sleep(10000);
    }

    @Test
    public synchronized void tester2() throws InterruptedException {
        MyThreadPoolImplScalable threadPoolExtendable = new MyThreadPoolImplScalable(5, 8);
        threadPoolExtendable.start();

//        threadPoolExtendable.shutdown();
        threadPoolExtendable.execute(new ThreadClass(1));
        threadPoolExtendable.execute(new ThreadClass(8));
        threadPoolExtendable.execute(new ThreadClass(75));
//        threadPoolExtendable.execute(new ThreadClass(10));
//        threadPoolExtendable.execute(new ThreadClass(75));
//        threadPoolExtendable.execute(new ThreadClass(75));
//        threadPoolExtendable.execute(new ThreadClass(75));
//        threadPoolExtendable.execute(new ThreadClass(75));
        Thread.sleep(10000);


    }
}


