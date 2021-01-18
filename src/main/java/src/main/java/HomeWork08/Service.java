package HomeWork08;

public interface Service {
    @CachedMap
    int doHardWork1(String work, int num);

    @CachedFile
    int doHardWork2(String work, int num);
}
