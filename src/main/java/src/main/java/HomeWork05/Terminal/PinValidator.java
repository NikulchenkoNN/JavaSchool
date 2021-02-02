package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;
import HomeWork05.Exceptions.IncorrectPinException;
import HomeWork05.Exceptions.NotValidEnter;

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

    public int checkNum(String str) throws NotValidEnter {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new NotValidEnter("Введено не число");
        }

        return num;
    }

    public void checkPin(int[] pin) throws IOException, AccountIsLockedException, IncorrectPinException {
        while (numberOfAttempts < 3) {
            if (numberOfAttempts == 2) {
                throw new AccountIsLockedException("Аккаунт заблокирован на 10 секунд");
            }
            while (pinCount < 4) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                int pinPart;
                try {
                    pinPart = checkNum(bufferedReader.readLine());
                    pinArray[pinCount] = pinPart;
                } catch (NotValidEnter incorrectPinException) {
                    System.out.println(incorrectPinException.getMessage());
                }

                if (pinArray[pinCount] != pin[pinCount]) {
                    throw new IncorrectPinException("Введен не верный пин");
                }
                pinCount++;
            }
        }
    }
}

