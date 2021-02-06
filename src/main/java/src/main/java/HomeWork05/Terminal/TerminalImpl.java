package HomeWork05.Terminal;

import HomeWork05.Exceptions.NotEnoughMoneyException;

import java.io.IOException;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;


    public TerminalImpl(TerminalServer server) {
        this.server = server;
    }

    @Override
    public void balance() {
        server.getBalance();
    }

    @Override
    public void withdrawal(int cash) throws  NotEnoughMoneyException {
        server.withdrawal(cash);
    }

    @Override
    public void refill(int fee)  {
        server.refill(fee);
    }

    public void access() throws IOException {
        server.accessToAccount();
    }
}
