package com.study.basic.module.interview;

/**
 * @author dzp 2020/12/9
 */
public class Compare {


    public static void main(String[] args) {
        // 将打印“String method”。
        // 首先，null 在 Java 中不是一个对象，
        // 在 Java 中我们可以将 null 赋给任何一个引用类型。
        // 而 Java 中的字符串是 Java.lang.String 类的对象。
        // 在这里，Java 编译器会选择使用最具体的参数类型来调用重载方法。
        // 而String类型比Object更为具体，所以会调用method(String s)方法。
        method(null);
        compareInter();
    }

    private static void method(Object obj) {
        System.out.println("Object method");
    }

    private static void method(String str) {
        System.out.println("String method");
    }

    /**
     * 每当使用“ == ”比较两个不同的对象引用时，值总是“false”。
     * 但是在这里，由于 Integer 缓存，num1和 num2是自动装箱的。
     * 因此num1 == num2返回“true”。
     * 同时，整数缓存只会发生在-128到127之间的值。
     */
    private static void compareInter() {
        Integer a = 128;
        Integer b = 128;
        Integer c = 127;
        Integer d = 127;

        System.out.println(a == b);
        System.out.println(c == d);
    }
}
