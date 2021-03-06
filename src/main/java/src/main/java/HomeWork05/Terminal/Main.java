package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;
import HomeWork05.Exceptions.NotEnoughMoneyException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AccountIsLockedException, IOException, NotEnoughMoneyException {
        int[] pin = new int[]{1, 2, 3, 4};
        BankAccount account = new BankAccount(pin, 500);
        PinValidator validator = new PinValidator();
        TerminalServer server = new TerminalServer(account, validator);
        TerminalImpl terminal = new TerminalImpl(server);

        terminal.access();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        terminal.balance();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        terminal.withdrawal(100);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        terminal.access();
        terminal.refill(500);
        terminal.balance();
    }
}
