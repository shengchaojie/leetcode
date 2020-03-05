package com.scj.leetcode.bst;

import java.util.Arrays;

/**
 * ֻ������������ �𰸲�Ψһ д����ͬ �𰸲�ͬ
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _108_����������ת��Ϊ���������� {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums ==null|| nums.length ==0) return null;

        int rootIndex = nums.length/2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,rootIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,rootIndex+1,nums.length));

        return root;

    }

    public static void main(String[] args) {
        _108_����������ת��Ϊ���������� _this = new _108_����������ת��Ϊ����������();
        TreeNode root = _this.sortedArrayToBST(new int[]{1,2,3,4,5});
        System.out.println(root);
    }

}
