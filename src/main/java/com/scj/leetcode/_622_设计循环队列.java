package com.scj.leetcode;

/**
 * @author shengchaojie
 * @date 2020-03-01
 **/
public class _622_设计循环队列 {

    static class MyCircularQueue {

        int size = 0;
        int first = 0;
        int[] elements ;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            elements = new int[k];
        }

        public int index(int index) {
            return (index + first) % elements.length;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }
            elements[index(size++)] = value;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }
            first = index(1);
            size--;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if(isEmpty()){
                return -1;
            }
            return elements[first];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if(isEmpty()){
                return -1;
            }
            return elements[index(size-1)];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return size ==0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return size == elements.length;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new  MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        queue.deQueue();
        queue.enQueue(3);
        System.out.println(queue.isFull());

    }


}
