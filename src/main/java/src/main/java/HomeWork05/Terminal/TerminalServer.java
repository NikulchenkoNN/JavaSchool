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

    public void checkSum(int summ) throws NumberIsNotMultipleException {
        if (summ%100 != 0) {
            throw new NumberIsNotMultipleException("Введённое число не кратно 100");
        }
    }

    public void withdrawal(int cash) throws NotEnoughMoneyException, NumberIsNotMultipleException {
        if (cash > this.balance) {
            throw new NotEnoughMoneyException("На Вашем счёте не достаточно средств");
        } else {
            checkSum(cash);
            this.balance = this.balance - cash;
            System.out.println("Выдано " + cash + " денег");
        }
    }

    public void refill(int fee) throws NumberIsNotMultipleException {
        checkSum(fee);
        this.balance = this.balance + fee;
        System.out.println("Пополнение на  " + fee + " денег");
    }
}
