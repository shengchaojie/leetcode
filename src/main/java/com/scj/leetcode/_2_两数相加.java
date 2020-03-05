package com.scj.leetcode;

/**
 * 递归 注意进位问题
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2 ,int extra){
        if(l1 == null && l2 ==null) return null;

        int sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) + extra;
        ListNode current = new ListNode(sum);
        ListNode next = addTwoNumbers(l1==null?null:l1.next,l2==null?null:l2.next,sum>=10?1:0);
        if(sum >=10){
            if(next ==null){
                next = new ListNode(1);
            }
            current.val -=10;
        }
        current.next =next;

        return current;
    }

}
