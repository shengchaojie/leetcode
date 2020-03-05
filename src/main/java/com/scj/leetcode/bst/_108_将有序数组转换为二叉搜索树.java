package com.scj.leetcode.bst;

import java.util.Arrays;

/**
 * 只有中序遍历结果 答案不唯一 写法不同 答案不同
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _108_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums ==null|| nums.length ==0) return null;

        int rootIndex = nums.length/2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,rootIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,rootIndex+1,nums.length));

        return root;

    }

    public static void main(String[] args) {
        _108_将有序数组转换为二叉搜索树 _this = new _108_将有序数组转换为二叉搜索树();
        TreeNode root = _this.sortedArrayToBST(new int[]{1,2,3,4,5});
        System.out.println(root);
    }

}
