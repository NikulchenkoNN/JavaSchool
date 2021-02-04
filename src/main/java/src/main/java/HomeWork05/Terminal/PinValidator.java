package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;
import HomeWork05.Exceptions.InvalidENterState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinValidator {
    private int pinCount = 0;
    private int numberOfAttempts = 0;
    private final int[] pinArray = new int[4];
    private final BankAccount account;

    public PinValidator(BankAccount account) {
        this.account = account;
    }

    public int checkNum(String str) throws InvalidENterState {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new InvalidENterState("Введено не число");
        }
        return num;
    }

    public int[] readPin() throws IOException, InvalidENterState, AccountIsLockedException {
        BankAccount.checkLock();
        int[] pin = new int[4];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (pinCount < 4) {
            try {
                pinArray[pinCount] = checkNum(bufferedReader.readLine());
                pinCount++;
            } catch (InvalidENterState invalidENterState) {
                throw new InvalidENterState("Введено не число");
            }
        }
        if (!BankAccount.checkPin(pinArray, pin)) {
            numberOfAttempts++;
        }
        if (numberOfAttempts == 3) {
            System.out.println("Аккакунт заблокирован на 10 секунд");
            BankAccount.Lock();
        }
        return pin;
    }
}

