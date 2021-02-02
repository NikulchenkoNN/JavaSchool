package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;

public class BankAccount {
    private boolean isLocked;
    private long lockTIme;
    private long currentTime;
    private int[] pin;

    public BankAccount(boolean isLocked, int[] pin) {
        this.isLocked = isLocked;
        this.pin = pin;
    }

    public void Locker(boolean isLocked) throws AccountIsLockedException {
        if (isLocked) {
            throw new AccountIsLockedException("Аккаунт заблокирован на 10 секунд");
        }
    }



}
