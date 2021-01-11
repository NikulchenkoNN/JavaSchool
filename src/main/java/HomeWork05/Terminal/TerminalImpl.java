package HomeWork05.Terminal;

import HomeWork05.Exceptions.NotEnoughMoneyException;
import HomeWork05.Exceptions.NumberIsNotMultipleException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalImpl implements Terminal{
    private TerminalServer server;
    private PinValidator pinValidator;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int pinCount = 0;
        while (pinCount < 4) {
            int pin = bufferedReader.read();

            pinCount++;
        }
    }

    @Override
    public int checkBalance() {
         return server.getBalance();
    }

    @Override
    public void withdrawal(int cash) {
        try {
            server.withdrawal(cash);
        } catch (NotEnoughMoneyException notEnoughMoneyException) {
            notEnoughMoneyException.printStackTrace();
        }
    }

    @Override
    public void refill(int fee) {
        try {
            server.checkSumm(fee);
        } catch (NumberIsNotMultipleException numberIsNotMultipleException) {
            numberIsNotMultipleException.printStackTrace();
        }
        server.refill(fee);
    }
}
