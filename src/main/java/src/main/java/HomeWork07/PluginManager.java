package HomeWork07;


import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        File file = new File(pluginRootDirectory);
        File[] listFiles = file.listFiles();
        for (File files : listFiles) {
            if (files.getName().equals(pluginName)) {
                Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(pluginClassName);
                Constructor<? extends Plugin> constructor = (Constructor<? extends Plugin>) clazz.getConstructor();
                Plugin plugin = constructor.newInstance();
                System.out.println(plugin.getClass().getName());
                plugin.doUseful();
                return plugin;
            }
        }

        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        PluginManager pluginManager = new PluginManager("D:\\Projects Java School\\src\\main\\java\\src\\main\\java\\HomeWork07");
        pluginManager.load("PluginImpl", "HomeWork07");
    }
}
