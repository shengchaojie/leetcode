package com.scj.leetcode.bst;

/**
 * shit 除了父节点 子节点也有可能不平衡 要层层递归去判断 如果不平衡 返回-1
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author shengchaojie
 * @date 2020-03-06
 **/
public class _110_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        return getBalance(root) != -1;
    }

    public int getBalance(TreeNode node){
        if(node ==null ) return 0;
        int left = getBalance(node.left);
        if(left == -1) return -1;
        int right = getBalance(node.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) >1) return -1;
        return 1 + Math.max(left,right);
    }

}
