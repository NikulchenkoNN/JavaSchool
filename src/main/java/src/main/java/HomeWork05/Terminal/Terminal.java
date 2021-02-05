package HomeWork05.Terminal;

import HomeWork05.Exceptions.NotEnoughMoneyException;
import HomeWork05.Exceptions.NumberIsNotMultipleException;

public interface Terminal {
    void withdrawal(int cash) throws NumberIsNotMultipleException, NotEnoughMoneyException;
    void refill(int fee) throws NumberIsNotMultipleException;
    void balance();
}
