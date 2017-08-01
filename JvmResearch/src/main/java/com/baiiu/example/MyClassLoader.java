package com.baiiu.example;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * author: baiiu
 * date: on 17/7/31 10:37
 * description:
 */
public class MyClassLoader extends ClassLoader {

    private String path = MyClassLoader.getSystemClassLoader().getResource("").getPath();
    ;


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class c = findLoadedClass(name);
        if (c == null) {
            try {
                c = findClass(name);
            } catch (Exception e) {
                return super.loadClass(name);
            }
        }

        return c;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data;
        try {
            data = loadClassData(name);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }

        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String className) throws IOException {
        String fileName = path +
                className.replace('.', File.separatorChar) + ".class";

        System.out.println(className + ", " + fileName);

        InputStream ins = new FileInputStream(fileName);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int length = 0;
        while ((length = ins.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos.toByteArray();
    }

    public static void main(String[] args) {

        MyClassLoader classLoader = new MyClassLoader();

        Class<?> testClass = null;
        try {
            testClass = classLoader.loadClass("com.baiiu.example.Test");
            Object object = testClass.newInstance();
            System.out.println(object.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}