package com.scj.leetcode;

/**
 * https://leetcode-cn.com/problems/design-circular-deque/
 *
 * @author shengchaojie
 * @date 2020-03-01
 **/
public class _641_设计循环双端队列 {

    public static class MyCircularDeque {

        int size, first;
        int[] elements;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            elements = new int[k];
        }

        private int index(int index) {
            index += first;
            if(index <0){
                return (index + elements.length) % elements.length;
            }
            return index>=elements.length?index-elements.length:index;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (size != 0) {
                first = index(- 1);
            }
            elements[first] = value;
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            elements[index(size)] = value;
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            first = index(1);
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return elements[first];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return elements[index(size - 1)];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == elements.length;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(8); // 设置容量大小为3
        circularDeque.insertFront(1);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertFront(3);                    // 返回 true
        circularDeque.insertFront(4);
        circularDeque.insertFront(5);
        circularDeque.deleteLast(); // 已经满了，返回 false
        circularDeque.getRear();                // 返回 2
        circularDeque.isFull();                        // 返回 true
        circularDeque.deleteLast();                    // 返回 true
        circularDeque.insertFront(4);                    // 返回 true
        circularDeque.getFront();                // 返回 4

    }

}
