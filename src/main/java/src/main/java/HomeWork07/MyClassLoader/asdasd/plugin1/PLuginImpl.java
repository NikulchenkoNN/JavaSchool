package HomeWork07.MyClassLoader.asdasd.plugin1;

import HomeWork07.MyClassLoader.Plugin;

public class PLuginImpl implements Plugin {
    public static void main(String[] args) {
        System.out.println(PLuginImpl.class.getName());
    }

    @Override
    public void doUseful() {
        System.out.println("Correct");
    }
}
