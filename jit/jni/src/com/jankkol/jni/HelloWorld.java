package com.jankkol.jni;

public class HelloWorld {
    public native void sayHello();

    static {
        System.loadLibrary("hello");
    }

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        hello.sayHello();
    }
}
