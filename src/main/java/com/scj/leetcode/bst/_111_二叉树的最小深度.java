package com.scj.leetcode.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author shengchaojie
 * @date 2020-03-29
 **/
public class _111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (--size >= 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return level;
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return level;
    }

}
