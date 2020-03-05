package com.scj.leetcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ���߳�ʵ�ֵȴ�����߲���countdownlatch����������������������synchronize �ȴ������仯
 * https://leetcode-cn.com/problems/print-in-order/
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _1114_�����ӡ {

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
