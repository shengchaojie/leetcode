package com.scj.leetcode.bst;

import java.util.*;

/**
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _107_二叉树的层次遍历II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();

        queue.add(root);

        while(!queue.isEmpty()){
            List<TreeNode> exists = new ArrayList<>();
            while(!queue.isEmpty()){
                exists.add(queue.poll());
            }
            List<Integer> nums = new ArrayList<>();
            for(TreeNode node : exists){
                nums.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            stack.push(nums);
        }

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

}
