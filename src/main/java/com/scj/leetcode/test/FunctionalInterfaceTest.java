package com.scj.leetcode.test;

/**
 * @author shengchaojie
 * @date 2020-05-11
 **/
public class FunctionalInterfaceTest {


    public static interface TestFunctionalInterface{

        String hello();

    }


    public static void main(String[] args) {
        TestFunctionalInterface testFunctionalInterface = ()->"hello";
        System.out.println(testFunctionalInterface.getClass().getName());
        test(testFunctionalInterface);
    }


    public static void test(TestFunctionalInterface testFunctionalInterface){
        System.out.println(testFunctionalInterface.hello());
    }


}
