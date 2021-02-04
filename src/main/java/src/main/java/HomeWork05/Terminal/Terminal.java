package HomeWork05.Terminal;

import HomeWork05.Exceptions.NumberIsNotMultipleException;

public interface Terminal {
    void withdrawal(int cash);
    void refill(int fee) throws NumberIsNotMultipleException;
    int balance();
}
