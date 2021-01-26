package HomeWork10.Part1;

import java.math.BigInteger;
import java.util.Date;

public class ThreadClass implements Runnable {
    private Integer num;

    public ThreadClass(Integer num) {
        this.num = num;
    }

    public BigInteger getFactorial(Integer num) {
        long start = System.nanoTime();
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        long time = System.nanoTime() - start;
            System.out.printf("Time required %d ms\n", time / 1000);
        return result;
    }

    @Override
    public synchronized void run() {
        BigInteger result = getFactorial(num);

            System.out.printf("Factorial of %d is %d\n", num, result);
            System.out.println("Thread name " + Thread.currentThread().getName());
            System.out.println();

    }
}