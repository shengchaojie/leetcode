package com.scj.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode-cn.com/problems/building-h2o/
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _1117_H2O生成 {

    class H2O {

        public H2O() {

        }

        Semaphore h  = new Semaphore(0);
        Semaphore h2o = new Semaphore(2);

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h2o.acquire(1);
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h.release(1);
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            h.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            h2o.release(2);
        }
    }

}
