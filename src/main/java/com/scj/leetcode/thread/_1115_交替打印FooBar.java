package com.scj.leetcode.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 还是线程等待问题，不过是交替等待
 * 这边采用 同步等待通知 + 标记变量
 * 感觉信号量 1 0 交替这种接法好一点
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _1115_交替打印FooBar {

    class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        volatile int flag = 1;



        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while(flag==0){
                        wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = 0;
                    notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while(flag==1){
                        wait();
                    }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                    flag = 1;
                    notify();
                }
            }
        }
    }

}
