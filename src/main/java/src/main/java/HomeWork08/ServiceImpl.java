package HomeWork08;

import java.io.*;

public class ServiceImpl implements Service, Externalizable {
    public static final long serialVersionUID = 1L;
    private String work;
    private int num;

    public ServiceImpl(String work, int num) {
        this.work = work;
        this.num = num;
    }

    public ServiceImpl() {
    }

    @Override
    public int doHardWork1(String work, int num) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return num + 5;
    }

    @Override
    public int doHardWork2(String work, int num) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return num + 3;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

}
