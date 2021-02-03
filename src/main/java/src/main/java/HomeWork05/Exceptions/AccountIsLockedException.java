package HomeWork05.Exceptions;

public class AccountIsLockedException extends Exception{
    public AccountIsLockedException(String message, long l) {
        super(message);
    }
}
