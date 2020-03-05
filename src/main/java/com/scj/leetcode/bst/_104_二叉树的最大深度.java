package com.scj.leetcode.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author shengchaojie
 * @date 2020-03-02
 **/
public class _104_二叉树的最大深度 {

    /**
     * iterate
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root==null)return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            List<TreeNode> tree = new ArrayList<>();
            while(!queue.isEmpty()){
                tree.add(queue.poll());
            }
            for(TreeNode node : tree){
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
        }
        return level;
    }

    /**
     * recursion
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
