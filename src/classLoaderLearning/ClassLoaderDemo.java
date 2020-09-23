package classLoaderLearning;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception{
        File file = new File("/Users/heling/Temp");
        URI uri = file.toURI();
        URL url = uri.toURL();

        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});

        System.out.println(classLoader.getParent());
        Class<?> aClass = classLoader.loadClass("com.heling.MyDemo");
        aClass.newInstance();

    }
}
