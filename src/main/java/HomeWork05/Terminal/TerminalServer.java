package HomeWork05.Terminal;

import HomeWork05.Exceptions.NotEnoughMoneyException;
import HomeWork05.Exceptions.NumberIsNotMultipleException;

public class TerminalServer {
    private int balance;

    public TerminalServer(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int checkBalance() {
        return getBalance();
    }

    public void checkSumm(int summ) throws NumberIsNotMultipleException {
        if (summ%100 != 0) {
            throw new NumberIsNotMultipleException("Введённое число не кратно 100");
        }
    }

    public void withdrawal(int cash) throws NotEnoughMoneyException {
        if (cash > balance) {
            throw new NotEnoughMoneyException("На Вашем счёте не достаточно средств");
        } else {
            setBalance(getBalance() - cash);
            System.out.println("Выдано "+cash + " денег");
        }
    }

    public void refill(int fee) {
        setBalance(getBalance() + fee);
    }
}
