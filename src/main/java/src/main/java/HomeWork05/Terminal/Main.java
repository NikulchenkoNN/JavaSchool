package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;
import HomeWork05.Exceptions.InvalidENterState;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AccountIsLockedException, InvalidENterState, IOException {
        int[] pin = new int[]{1, 2, 3, 4};
        BankAccount account = new BankAccount(pin);
        TerminalServer server = new TerminalServer(500);
        PinValidator validator = new PinValidator(account);
        TerminalImpl terminal = new TerminalImpl(server, validator, account);


        int[] pinToCheck = validator.readPin();
    }
}
