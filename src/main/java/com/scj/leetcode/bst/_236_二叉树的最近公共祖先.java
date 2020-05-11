package com.scj.leetcode.bst;

import java.util.*;

/**
 * @author shengchaojie
 * @date 2020-05-10
 **/
public class _236_二叉树的最近公共祖先 {

    /**
     * 最佳 通过后序遍历 递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null || root ==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left ==null && right ==null) return null;
        if(left==null)return right;
        if(right==null)return left;
        return root;
    }


    /**
     * 用hashmap保存每个节点的父节点
     * 找出p的路径存到set
     * 然后从p的路径从下往上找 第一个出现的节点就是 公共节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null || p ==null || q ==null) return null;
        if(p==q) return p;
        //<child,parent>
        HashMap<Integer,TreeNode> map = new HashMap<>();
        traversal(map,root);

        Set<Integer> pPath = new HashSet<>();
        TreeNode parent = p;
        while(parent!=null){
            pPath.add(parent.val);
            parent = map.get(parent.val);
        }

        parent=q;
        while(parent!=null){
            if(pPath.contains(parent.val)){
                return parent;
            }
            parent = map.get(parent.val);
        }

        return null;
    }

    public void traversal(HashMap<Integer,TreeNode> map,TreeNode node){
        if(node ==null) return;
        if(node.left!=null)
        map.put(node.left.val,node);
        if(node.right!=null)
        map.put(node.right.val,node);
        traversal(map,node.left);
        traversal(map,node.right);
    }

}
