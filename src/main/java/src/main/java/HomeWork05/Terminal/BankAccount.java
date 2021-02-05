package HomeWork05.Terminal;

import java.util.Date;

public class BankAccount {
    private static boolean isLock = true;
    private volatile long lockTIme;
    private static int[] pin;
    private int balance;


    public BankAccount(int[] pin, int balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public void Lock() {
        lockTIme = new Date().getTime();
        isLock = false;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isLock = true;
            }
        });
        thread.start();
    }

    public boolean checkLock() {
        if (isLock) {
            System.out.printf("Аккаунт заблокирован еще %d сек", (new Date().getTime() - lockTIme));
        }
        return isLock;
    }

    public  int[] getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setLock(boolean lock) {
        BankAccount.isLock = lock;
    }

    public long getLockTIme() {
        return lockTIme;
    }
}
