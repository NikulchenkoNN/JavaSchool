package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;

public class BankAccount {
    private boolean lock;
    private long lockTIme;

    public BankAccount() {
    }

    void Lock() {
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

    public void checkLock() throws AccountIsLockedException {
        if (lock){
            throw new AccountIsLockedException("Аккаунт заблокирован еще %s секунд \n", (System.nanoTime() - this.lockTIme)/1000);
        }
    }
}
