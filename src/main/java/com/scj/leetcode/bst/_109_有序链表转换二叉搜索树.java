package com.scj.leetcode.bst;


/**
 * 最优解
 * 使用快慢指针查找链表中点
 * 而不是先转换成数组
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _109_有序链表转换二叉搜索树 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head ==null)return null;
        if(head.next ==null) return new TreeNode(head.val);

        ListNode fast = head,slow =head,pre=head;
        while(fast!=null &&fast.next!=null){
            fast = fast.next;
            if(fast !=null){
                fast = fast.next;
            }
            pre = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        pre.next =null;
        root.left = sortedListToBST(head);
        return root;
    }

}
