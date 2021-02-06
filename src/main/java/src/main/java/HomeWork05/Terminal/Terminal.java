package HomeWork05.Terminal;

import HomeWork05.Exceptions.NotEnoughMoneyException;

public interface Terminal {
    void withdrawal(int cash) throws NotEnoughMoneyException;
    void refill(int fee);
    void balance();
}
