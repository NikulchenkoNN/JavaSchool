package HomeWork05.Terminal;

import HomeWork05.Exceptions.AccountIsLockedException;
import HomeWork05.Exceptions.NotEnoughMoneyException;
import HomeWork05.Exceptions.NumberIsNotMultipleException;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private PinValidator pinValidator;
    private final BankAccount account;

    public TerminalImpl(TerminalServer server, PinValidator pinValidator, BankAccount account) {
        this.server = server;
        this.pinValidator = pinValidator;
        this.account = account;
    }

    @Override
    public int balance() {
        try {
            account.checkLock();
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
        }
        return server.getBalance();
    }

    @Override
    public void withdrawal(int cash) {
        try {
            account.checkLock();
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
        }
        try {
            server.checkSum(cash);
            server.withdrawal(cash);
        } catch (NotEnoughMoneyException | NumberIsNotMultipleException notEnoughMoneyException) {
            notEnoughMoneyException.printStackTrace();
        }
    }

    @Override
    public void refill(int fee) throws NumberIsNotMultipleException {
        try {
            account.checkLock();
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
        }
        try {
            server.checkSum(fee);
        } catch (NumberIsNotMultipleException numberIsNotMultipleException) {
            numberIsNotMultipleException.printStackTrace();
        }
        server.refill(fee);
    }
}
