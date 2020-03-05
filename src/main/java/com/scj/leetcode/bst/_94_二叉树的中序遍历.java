package com.scj.leetcode.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author shengchaojie
 * @date 2020-03-02
 **/
public class _94_二叉树的中序遍历 {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderTraversal(root, result);
            return result;
        }

        public void inorderTraversal(TreeNode node, List<Integer> nums) {
            if(node ==null) return;
            inorderTraversal(node.left, nums);
            nums.add(node.val);
            inorderTraversal(node.right, nums);
        }

        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> result  = new ArrayList<>();
            if(root ==null) return result;
            Stack<TreeNode> stack = new Stack<>();
            while(root!=null || !stack.isEmpty()){
                while (root!=null){
                    stack.push(root);
                    root = root.left;
                }
                TreeNode node = stack.pop();
                result.add(node.val);
                root = node.right;
            }
            return result;
        }
    }

}
