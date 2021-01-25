package HomeWork10;

import java.math.BigInteger;
import java.util.Date;

public class ThreadClass implements Runnable {
    private Integer num;

    public ThreadClass(Integer num) {
        this.num = num;
    }

    public BigInteger getFactorial(Integer num) {
        Date start = new Date();
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        Date end = new Date();
        long time = end.getTime() - start.getTime();

        System.out.println("Time required " + time + " ms");
        return result;
    }

    @Override
    public void run() {
        BigInteger result = getFactorial(num);
        System.out.println("Factorial of " + num + " is " + result);
    }
}