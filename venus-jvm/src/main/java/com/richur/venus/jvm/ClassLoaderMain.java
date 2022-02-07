package com.richur.venus.jvm;

/**
 * start...
 * sun.misc.Launcher$AppClassLoader@18b4aac2
 * sun.misc.Launcher$ExtClassLoader@119d7047
 * end...
 */
public class ClassLoaderMain {
    public static void main(String[] args) {
        System.out.println("start...");
        ClassLoaderMain main = new ClassLoaderMain();
        ClassLoader classLoader = main.getClass().getClassLoader();
        System.out.println(classLoader);

        while(classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
        System.out.println("end...");


    }
}
