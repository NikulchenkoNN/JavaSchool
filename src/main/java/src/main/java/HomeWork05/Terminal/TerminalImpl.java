package HomeWork05.Terminal;

import HomeWork05.Exceptions.IncorrectPinException;
import HomeWork05.Exceptions.NotEnoughMoneyException;
import HomeWork05.Exceptions.NumberIsNotMultipleException;

import java.io.IOException;

public class TerminalImpl implements Terminal{
    private TerminalServer server;
    private PinValidator pinValidator;
    private BankAccount account;

    @Override
    public int checkBalance() {
        if (account.isLocked()) {
            System.out.printf("Аккаунт заблокирован еще %s секунд \n", (System.nanoTime() - account.getLockTIme())/1000);
        }
        return server.getBalance();
    }

    @Override
    public void withdrawal(int cash) {
        if (account.isLocked()) {
            System.out.printf("Аккаунт заблокирован еще %s секунд \n", (System.nanoTime() - account.getLockTIme())/1000);
        }
        try {
            server.checkSumm(cash);
            server.withdrawal(cash);
        } catch (NotEnoughMoneyException | NumberIsNotMultipleException notEnoughMoneyException) {
            notEnoughMoneyException.printStackTrace();
        }
    }

    @Override
    public void refill(int fee) {
        if (account.isLocked()) {
            System.out.printf("Аккаунт заблокирован еще %s секунд \n", (System.nanoTime() - account.getLockTIme())/1000);
        }
        try {
            server.checkSumm(fee);
        } catch (NumberIsNotMultipleException numberIsNotMultipleException) {
            numberIsNotMultipleException.printStackTrace();
        }
        server.refill(fee);
    }
}
