package HomeWork05.Terminal;

import HomeWork05.Exceptions.NotEnoughMoneyException;
import HomeWork05.Exceptions.NumberIsNotMultipleException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class TerminalServer {
    private final BankAccount account;
    private final PinValidator validator;
    private int numberOfAttempts = 0;

    public TerminalServer(BankAccount account, PinValidator validator) {
        this.account = account;
        this.validator = validator;
    }

    public void getBalance() {
        if (!account.checkLock()) {
            System.out.printf("На счете осталось %d денег \n", account.getBalance());
        }
    }

    public boolean checkSum(int summ) throws NumberIsNotMultipleException {
        if (summ % 100 == 0) {
            return true;
        }
        return false;
    }

    public void withdrawal(int cash) throws NotEnoughMoneyException, NumberIsNotMultipleException {
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
        } else {
            System.out.printf("Аккаунт заблокирован еще %d", new Date().getTime() - account.getLockTIme());
        }
    }

    public void refill(int fee) throws NumberIsNotMultipleException {
        if (!account.checkLock()) {
            if (checkSum(fee)) {
                account.setBalance(account.getBalance() + fee);
                System.out.println("Пополнение на " + fee + " денег");
            } else {
                System.out.println("Введено не корректное значение");
            }
        } else {
            System.out.printf("Аккаунт заблокирован еще %d", new Date().getTime() - account.getLockTIme());
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
