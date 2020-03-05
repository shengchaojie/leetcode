package com.scj.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * https://leetcode-cn.com/problems/the-dining-philosophers/
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _1226_哲学家进餐 {

    class DiningPhilosophers {
        /**
         * 叉子的状态
         */
        Semaphore fork_1_status = new Semaphore(1);
        Semaphore fork_2_status = new Semaphore(1);
        Semaphore fork_3_status = new Semaphore(1);
        Semaphore fork_4_status = new Semaphore(1);
        Semaphore fork_5_status = new Semaphore(1);

        Semaphore[] fork_status = new Semaphore[]{fork_1_status,fork_2_status,fork_3_status,fork_4_status,fork_5_status};

        public DiningPhilosophers() {

        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            //锁定叉子
            Semaphore left = fork_status[philosopher];
            Semaphore right = fork_status[(philosopher+1)%5];

            while (true){
                if(philosopher%2==0) {
                    if (left.tryAcquire(1)) {
                        if (right.tryAcquire(1)) {
                            pickLeftFork.run();
                            pickRightFork.run();
                            eat.run();
                            putLeftFork.run();
                            left.release();
                            putRightFork.run();
                            right.release();
                            break;
                        } else {
                            left.release();
                            Thread.yield();
                        }
                    } else {
                        Thread.yield();
                    }
                }else{
                    if (right.tryAcquire(1)) {
                        if (left.tryAcquire(1)) {
                            pickLeftFork.run();
                            pickRightFork.run();
                            eat.run();
                            putRightFork.run();
                            right.release();
                            putLeftFork.run();
                            left.release();
                            break;
                        } else {
                            right.release();
                            Thread.yield();
                        }
                    } else {
                        Thread.yield();
                    }
                }
            }
        }
    }

}
