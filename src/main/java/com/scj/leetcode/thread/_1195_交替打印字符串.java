package com.scj.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * �ؼ����� ��forѭ��ִ�� ��������һ�������
 * ��������ֵ��̵߳�Э����
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 *
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _1195_�����ӡ�ַ��� {


    public static class FizzBuzz {
        private int n;

        public FizzBuzz(int n) {
            this.n = n;
        }

        Semaphore _0 = new Semaphore(0);
        Semaphore _3 = new Semaphore(0);
        Semaphore _5 = new Semaphore(0);
        Semaphore _35 = new Semaphore(0);

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    _3.acquire();
                    printFizz.run();
                    _0.release();
                }
            }

        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    _5.acquire();
                    printBuzz.run();
                    _0.release();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    _35.acquire();
                    printFizzBuzz.run();
                    _0.release();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    _35.release();
                    _0.acquire();
                }else if(i % 3 == 0){
                    _3.release();
                    _0.acquire();
                }else if(i %5 ==0){
                    _5.release();
                    _0.acquire();
                }else{
                    printNumber.accept(i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> {
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> {
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> {
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
