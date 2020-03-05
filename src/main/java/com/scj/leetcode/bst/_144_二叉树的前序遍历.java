package com.scj.leetcode.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @author shengchaojie
 * @date 2020-03-02
 **/
public class _144_二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root,result);
        return result;
    }

    /**
     * recursion
     * @param node
     * @param nums
     */
    public void preorderTraversal(TreeNode node,List<Integer> nums){
        if(node==null){
            return;
        }
        nums.add(node.val);
        preorderTraversal(node.left,nums);
        preorderTraversal(node.right,nums);
    }

    /**
     * iterate ( use stack )
     */
    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        //while 这个条件真难搞。。
        while (root!=null|| stack.size() >0){
            while(root!=null){
                result.add(root.val);
                stack.add(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if(node !=null) {
                root = node.right;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        _144_二叉树的前序遍历 _this = new _144_二叉树的前序遍历();
        _this.preorderTraversal2(root);

    }


}
