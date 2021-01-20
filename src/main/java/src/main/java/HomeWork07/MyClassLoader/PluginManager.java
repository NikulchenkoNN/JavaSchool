package HomeWork07.MyClassLoader;


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
                plugin.doUseful();
                return plugin;
            }
        }
        return null;
    }

}
