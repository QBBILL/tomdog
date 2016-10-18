package loader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by 钱斌 on 2016/8/26.
 */
public class TestUrlClassLoader {

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("org.apache.commons.lang3.StringUtils");
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File("D:" + File.separator + "commons-lang3-3.1.jar");
        URL url = file.toURI().toURL();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
        //This class loader is used to load classes and resources from a search path of URLs referring to both JAR files and directories
        Class clazz = urlClassLoader.loadClass("org.apache.commons.lang3.StringUtils");
        Method isEmpty = clazz.getMethod("isEmpty", CharSequence.class);
        System.out.println(isEmpty.invoke(null, "This is not empty!"));
    }
}
