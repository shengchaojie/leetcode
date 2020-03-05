package com.scj.leetcode.bst;

/**
 * https://leetcode-cn.com/problems/same-tree/
 * �ݹ� ûɶ��˵��
 *
 * @author shengchaojie
 * @date 2020-03-03
 **/
public class _100_��ͬ���� {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
