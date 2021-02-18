package HomeWork07.EncryptedClassLoader;

import java.io.File;

public class EncryptedClassLoader extends ClassLoader {
    private final String key;
    private final File dir;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File[] listFile = dir.listFiles();

        return super.findClass(name);
    }

//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//
//        Class<?> c = findLoadedClass(name);
//        if (c == null) {
//            try {
//                try {
//                    if (parent != null) {
//                        c = parent.loadClass(name, false);
//                    } else {
//                        c = findBootstrapClassOrNull(name);
//                    }
//                } catch (ClassNotFoundException ignore) {
//                    if (c == null) c = findClass(name);
//                }
//                return c;
//
//            }
//
//        }
//    }
}
