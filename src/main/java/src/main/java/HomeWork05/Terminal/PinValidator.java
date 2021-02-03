package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;
import HomeWork05.Exceptions.NotValidEnter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PinValidator {
    private int pinCount = 0;
    private int numberOfAttempts = 0;
    private final int[] pinArray = new int[4];
    private BankAccount account;

    public PinValidator() {
    }

    public int checkNum(String str) throws NotValidEnter {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new NotValidEnter("Введено не число");
        }
        return num;
    }

    public void checkPin(int[] pin) throws IOException, NotValidEnter, AccountIsLockedException {
        account.checkLock();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (pinCount < 4) {
            try {
                pinArray[pinCount] = checkNum(bufferedReader.readLine());
                pinCount++;
            } catch (NotValidEnter notValidEnter) {
                throw new NotValidEnter("Введено не число");
            }
        }
        if (!Arrays.equals(pinArray, pin)) {
            numberOfAttempts++;
        }
        if (numberOfAttempts == 3) {
            System.out.println("Аккакунт заблокирован на 10 секунд");
            account.Lock();
        }

    }
}

