package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;
import HomeWork05.Exceptions.NotEnoughMoneyException;
import HomeWork05.Exceptions.NumberIsNotMultipleException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AccountIsLockedException, IOException, NumberIsNotMultipleException, NotEnoughMoneyException {
        int[] pin = new int[]{1, 2, 3, 4};
        BankAccount account = new BankAccount(pin, 500);
        PinValidator validator = new PinValidator();
        TerminalServer server = new TerminalServer(account, validator);
        TerminalImpl terminal = new TerminalImpl(server);

        terminal.access();
        terminal.balance();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        terminal.withdrawal(100);
        terminal.refill(500);
        terminal.balance();
    }
}
