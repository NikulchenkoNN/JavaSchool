package HomeWork05.Terminal;

import HomeWork05.Exceptions.IncorrectPinException;
import HomeWork05.Exceptions.NotEnoughMoneyException;
import HomeWork05.Exceptions.NumberIsNotMultipleException;

import java.io.IOException;

public class TerminalImpl implements Terminal{
    private TerminalServer server;
    private PinValidator pinValidator;

    public static void main(String[] args) throws IOException {

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
