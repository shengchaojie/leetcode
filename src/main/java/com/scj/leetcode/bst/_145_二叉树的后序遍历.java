package com.scj.leetcode.bst;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author shengchaojie
 * @date 2020-03-02
 **/
public class _145_二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result  = new ArrayList<>();
        Set<Integer> must = new HashSet<>();
        if(root ==null) return result;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if(node.right ==null){
                result.add(node.val);
            }else{
                root = node.right;
                //为了断开连接 深拷贝一个
                stack.push(new TreeNode(node.val));
            }
        }
        return result;
    }


    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root,result);
        return result;
    }

    public void postorderTraversal(TreeNode root,List<Integer> nums){
        if(root ==null) return;
        postorderTraversal(root.left,nums);
        postorderTraversal(root.right,nums);
        nums.add(root.val);
    }

}
