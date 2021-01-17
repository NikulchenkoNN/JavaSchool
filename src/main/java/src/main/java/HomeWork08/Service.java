package HomeWork08;

public interface Service {
    @Cache
    int doHardWork(String work, int num);
}
