package HomeWork08;

public class ServiceImpl implements Service{
    @Override
    public int doHardWork(String work, int num) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return num+5;
    }
}
