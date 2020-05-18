package com.scj.leetcode;

/**
 * @author shengchaojie
 * @date 2020-05-17
 **/
public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode end = head;
        while(end!=null){
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
        listNode1.next =listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        _206_反转链表 _this = new _206_反转链表();
        ListNode newNode = _this.reverseList(listNode1);
    }

}
