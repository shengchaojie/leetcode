package com.scj.leetcode.test;

/**
 * @author shengchaojie
 * @date 2020-05-10
 **/
public class LambdaTest {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Lambda Thread run()");
        System.out.println(runnable.getClass().getName());
        new Thread(
               runnable
        ).start();;
    }

}
