package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;
import HomeWork05.Exceptions.IncorrectPinException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinValidator {
    private int pinCount = 0;
    private int numberOfAttempts = 0;
    private int[] pinArray = new int[4];
    private int currentTime;
    private int blockTime;

    public PinValidator() {
    }

    public boolean checkNum(Integer num) throws IncorrectPinException {
        if (num instanceof Integer) {
            return true;
        } else {
            throw new IncorrectPinException("Введено не число");
        }
    }

    public void checkPin() throws IOException, AccountIsLockedException {
        while (numberOfAttempts < 3) {
            if (numberOfAttempts == 2) {
                throw new AccountIsLockedException("Аккаунт заблокирован на 10 секунд");
            }
            while (pinCount < 4) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                int pinPart = Integer.parseInt(bufferedReader.readLine());
                try {
                    checkNum(pinPart);
                } catch (IncorrectPinException incorrectPinException) {
                    numberOfAttempts++;
                }
                pinArray[pinCount] = pinPart;
                pinCount++;
            }
        }
    }
}

