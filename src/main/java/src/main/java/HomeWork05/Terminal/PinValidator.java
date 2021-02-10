package HomeWork05.Terminal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinValidator {
    private int pinCount;
    private final int[] pinArray = new int[4];

    public PinValidator() {
    }

    public int[] readPin() throws IOException {
        pinCount = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (pinCount < 4) {
            int num;
            try {
                num = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException ex) {
                System.out.println("Введено не число");
                continue;
            }
            pinArray[pinCount] = num;
            pinCount++;
        }
        return pinArray;
    }
}

