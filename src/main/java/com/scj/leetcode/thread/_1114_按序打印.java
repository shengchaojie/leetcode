package com.scj.leetcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 让线程实现等待，这边采用countdownlatch，还可以自旋变量，或者synchronize 等待条件变化
 * https://leetcode-cn.com/problems/print-in-order/
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _1114_按序打印 {

    public static class Foo {

        public Foo() {

        }

        CountDownLatch a = new CountDownLatch(1);
        CountDownLatch b = new CountDownLatch(1);

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            a.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            a.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            b.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            b.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
