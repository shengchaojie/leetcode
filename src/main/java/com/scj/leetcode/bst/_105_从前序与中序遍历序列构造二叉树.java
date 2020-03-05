package com.scj.leetcode.bst;

import java.util.Arrays;

/**
 * mmp 递归 头疼
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _105_从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0&&inorder.length==0)return null;
        int rootIndex = 0;
        while(inorder[rootIndex]!=preorder[0]){rootIndex++;}
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,1+rootIndex),Arrays.copyOfRange(inorder,0,rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder,1+rootIndex,preorder.length),Arrays.copyOfRange(inorder,rootIndex+1,inorder.length));
        return root;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1};
        //Arrays.copyOfRange这方法有毒 居然from从1开始没事 下面默认返回空数组
        int[] b =Arrays.copyOfRange(a,1,1);
        int[] c =Arrays.copyOfRange(a,1,4);
        int[] d =Arrays.copyOfRange(a,0,4);
        System.out.println(b);
    }

}
