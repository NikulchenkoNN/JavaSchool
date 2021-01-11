package HomeWork05.Terminal;

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
        while (numberOfAttempts < 3) {
            while (pinCount < 4) {
                try {
                    int pin = Integer.parseInt(bufferedReader.readLine());
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Введено не число");
                }
                pinCount++;
            }
            numberOfAttempts++;
        }
        bufferedReader.close();
        return true;
    }
}

