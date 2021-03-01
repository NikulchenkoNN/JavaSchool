package HomeWork07;


import HomeWork07.MyClassLoader.PluginManager;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class PluginManagerTest {
    @Test
    public void PluginManager() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        PluginManager pluginManager = new PluginManager("C:\\Projects\\JavaSchool\\src\\main\\java\\target\\classes\\HomeWork07\\asdasd");
        pluginManager.load("plugin1", "HomeWork07.asdasd.plugin1.PLuginImpl");
        pluginManager.load("plugin2", "HomeWork07.asdasd.plugin2.PLuginImpl");
    }
}