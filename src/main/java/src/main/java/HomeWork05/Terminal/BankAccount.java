package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;

import java.util.Date;
import java.util.Timer;

public class BankAccount {
    private boolean isLocked;
    private long lockTIme;

    public BankAccount() {
    }

    void Locker() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                isLocked = true;
                lockTIme = System.nanoTime();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isLocked = false;
            }
        });
    }

    public long getLockTIme() {
        return lockTIme;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
