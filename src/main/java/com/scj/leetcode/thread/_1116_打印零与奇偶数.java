package com.scj.leetcode.thread;

import java.util.function.IntConsumer;

/**
 * 还是用semaphore最为方便 1 0 0 的semaphore
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _1116_打印零与奇偶数{

    class ZeroEvenOdd {
        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        volatile int flag = 0;

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for(int i =0;i< n;i++){
                synchronized (this){
                    while(flag !=0 && flag !=2){
                        wait();
                    }
                    printNumber.accept(0);
                    flag +=1;
                    notifyAll();
                }

            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for(int i =2 ;i<=n;i+=2){
                synchronized (this){
                    while(flag !=3){
                        wait();
                    }
                    printNumber.accept(i);
                    flag =0;
                    notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(int i =1 ;i<=n;i+=2){
                synchronized (this){
                    while(flag !=1){
                        wait();
                    }
                    printNumber.accept(i);
                    flag =2;
                    notifyAll();
                }
            }
        }
    }

}
