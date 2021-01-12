package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinValidator {
    private int pinCount = 0;
    private int numberOfAttempts = 0;

    public PinValidator() {
    }

    public boolean chekPin() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (pinCount < 4) {
            if (numberOfAttempts == 3) {
                try {
                    throw new AccountIsLockedException("Аккаунт заблокирован на 10 секунд");
                } catch (AccountIsLockedException e) {
                }
            } else {
                try {
                    int pin = Integer.parseInt(bufferedReader.readLine());
                } catch (NumberFormatException | IOException e) {
                    numberOfAttempts++;
                    System.out.println("Введено не число");
                }
                pinCount++;
            }
        }


        bufferedReader.close();
        return true;
    }
}

