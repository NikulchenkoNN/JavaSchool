package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;

import java.util.Arrays;

public class BankAccount {
    private static boolean lock = false;
    private static long lockTIme;
    private static int[] pin;

    public BankAccount(int[] pin) {
        this.pin = pin;
    }

    static void Lock() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock = true;
                lockTIme = System.nanoTime();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock = false;
            }
        });
        thread.start();
    }

    public static boolean checkPin(int[] pinArray, int[] pinToCheck) {
        return Arrays.equals(pin, pinToCheck);
    }

    public static void checkLock() throws AccountIsLockedException {
        if (lock){
            throw new AccountIsLockedException("Аккаунт заблокирован еще %s секунд \n", (System.nanoTime() - lockTIme)/1000);
        }
    }
}
