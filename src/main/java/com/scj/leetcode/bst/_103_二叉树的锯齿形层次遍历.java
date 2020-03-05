package com.scj.leetcode.bst;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _103_二叉树的锯齿形层次遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;

        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> nums = new ArrayList<>();
            List<TreeNode> tree = new ArrayList<>();
            while(!queue.isEmpty()){
                tree.add(queue.poll());
            }
            for(TreeNode node : tree){
                nums.add(node.val);
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
            if(index++%2 ==0){
                Collections.reverse(nums);
            }
            result.add(nums);
        }
        return result;
    }

}
