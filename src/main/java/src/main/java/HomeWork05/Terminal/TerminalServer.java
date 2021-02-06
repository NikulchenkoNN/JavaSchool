package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;
import HomeWork05.Exceptions.NotEnoughMoneyException;

import java.io.IOException;
import java.util.Arrays;

public class TerminalServer {
    private final BankAccount account;
    private final PinValidator validator;
    private int numberOfAttempts = 0;

    public TerminalServer(BankAccount account, PinValidator validator) {
        this.account = account;
        this.validator = validator;
    }

    public void getBalance() {
        try {
            if (!account.checkLock()) {
                System.out.printf("На счете осталось %d денег \n", account.getBalance());
            }
        } catch (AccountIsLockedException e) {
            e.getMessage();
        }
    }

    public boolean checkSum(int sum) {
        return sum % 100 == 0;
    }

    public void withdrawal(int cash) throws NotEnoughMoneyException{
        try {
            if (!account.checkLock()) {
                if (cash > account.getBalance()) {
                    throw new NotEnoughMoneyException("На Вашем счёте не достаточно средств");
                } else {
                    if (checkSum(cash)) {
                        account.setBalance(account.getBalance() - cash);
                        System.out.println("Выдано " + cash + " денег");
                    } else {
                        System.out.println("Введено не корректное значение");
                    }
                }
            }
        } catch (AccountIsLockedException e) {
            e.getMessage();
        }
    }

    public void refill(int fee) {
        try {
            if (!account.checkLock()) {
                if (checkSum(fee)) {
                    account.setBalance(account.getBalance() + fee);
                    System.out.println("Пополнение на " + fee + " денег");
                } else {
                    System.out.println("Введено не корректное значение");
                }
            }
        } catch (AccountIsLockedException e) {
            e.getMessage();
        }
    }

    public void accessToAccount() throws IOException {
        while (numberOfAttempts < 3) {
            int[] pin = validator.readPin();
            if (!checkPin(account.getPin(), pin)) {
                numberOfAttempts++;
                System.out.printf("Введен не верный пин. Попыток для ввода осталось %d \n", (3 - numberOfAttempts));
            } else {
                account.setLock(false);
                System.out.println("Вход разрешен");
                break;
            }
        }
        if (numberOfAttempts == 3) {
            account.Lock();
            System.out.println("Аккакунт заблокирован на 10 секунд");
            numberOfAttempts = 0;
        }
    }

    public static boolean checkPin(int[] accountPin, int[] enteredPin) {
        return Arrays.equals(accountPin, enteredPin);
    }
}
