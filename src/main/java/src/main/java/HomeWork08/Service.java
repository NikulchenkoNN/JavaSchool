package HomeWork08;

public interface Service {
    @Cache()
    int doHardWork(String work, int num);

    @Cache(fileName = "file", source = Sources.FILE)
    int doHardWork2(String work, int num);
}
