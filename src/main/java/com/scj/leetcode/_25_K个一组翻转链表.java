package com.scj.leetcode;

import java.util.LinkedList;

/**
 * @author shengchaojie
 * @date 2020-05-16
 **/
public class _25_K个一组翻转链表 {

    /**
     * 简单无脑写法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode sentinel = new ListNode(-1);
        int count = 0;
        ListNode current = sentinel;
        while (head != null) {
            stack.push(head.val);
            count++;
            if (count % k == 0) {
                while (!stack.isEmpty()) {
                    ListNode newNode = new ListNode(stack.poll());
                    current.next = newNode;
                    current = newNode;
                }
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            ListNode newNode = new ListNode(stack.pollLast());
            current.next = newNode;
            current = newNode;
        }
        return sentinel.next;
    }

    /**
     * 原地反转
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if(k==1)return head;
        //保存头结点
        ListNode newHead = head;
        //当前进行的元素
        ListNode current = head;
        //保存上次反转最后一个元素
        ListNode prev = null;
        while (current != null) {
            ListNode start = current, end = null;
            for (int i = 0; i < k - 1; i++) {
                if (current.next == null) {
                    return newHead;
                }
                current = current.next;
            }
            end = current;

            //拿下一个节点
            ListNode next = end.next;
            //断开连接
            end.next = null;
            //进行部分反转
            reverse(start);
            //保存头
            if (newHead == head) {
                newHead = end;
            }
            //连到下一个节点
            start.next = next;
            //上个节点指向这次反转最新节点
            if(prev!=null){
                prev.next = end;
            }
            current =next;
            prev = start;

        }

        return newHead;
    }

    /**
     * 返回最后一个节点
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode end = head;
        while (end != null) {
            ListNode next = end.next;
            end.next = dummy.next;
            dummy.next = end;
            end = next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        _25_K个一组翻转链表 _this = new _25_K个一组翻转链表();
        ListNode newList = _this.reverseKGroup2(listNode1, 2);
    }

}
