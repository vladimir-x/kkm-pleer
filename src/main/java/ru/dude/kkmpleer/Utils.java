package ru.dude.kkmpleer;

import java.lang.reflect.Field;

public class Utils {
    public static void setLibraryPath(String path) throws Exception {
        System.setProperty("java.library.path", path);

        // Set sys_paths to null so that java.library.path will be reevalueted next time it is needed
        final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
        sysPathsField.setAccessible(true);

    }

    public static String selectNativeLibraryPath() {

        String home = System.getProperty("user.dir");
        String osName = System.getProperty("os.name").toLowerCase();
        String javaArch = System.getProperty("os.arch").toLowerCase();
        if (osName.contains("windows")) {
            String prefix = home + "\\lib\\native\\";

            if (javaArch.contains("86")) {
                return prefix + "windows-86";
            }
            if (javaArch.contains("64")) {
                return prefix + "windows-64";
            }
        }

        if (osName.contains("linux")) {
            String prefix = home + "/lib/native/";

            if (javaArch.contains("86")) {
                return prefix + "linux-86";
            }
            if (javaArch.contains("64")) {
                return prefix + "linux-64";
            }
        }

        throw new RuntimeException("Unknown os and arch :" + osName + " " + javaArch);
    }

}
