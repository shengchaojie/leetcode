package com.scj.leetcode.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shengchaojie
 * @date 2020-03-02
 **/
public class _102_二叉树的层次遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;

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
            result.add(nums);
        }
        return result;
    }

}
