package com.scj.leetcode.demo;

import java.util.Comparator;

/**
 * @author shengchaojie
 * @date 2020-03-05
 **/
public class AVLTree<E> {

    private Comparator<E> comparator;

    private AVLNode<E> root;

    public AVLTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public AVLNode<E> add(E element) {
        if (root == null) {
            root = new AVLNode<>(element, null);
            return root;
        }

        AVLNode<E> node = root;
        while (node != null) {
            if (comparator.compare(element, node.element) > 0) {
                if (node.right == null) {
                    node.right = new AVLNode<>(element, node);
                    afterNodeAdd(node.right);
                    return root;
                }
                node = node.right;

            } else if (comparator.compare(element, node.element) < 0) {
                if (node.left == null) {
                    node.left = new AVLNode<>(element, node);
                    afterNodeAdd(node.left);
                    return root;
                }
                node = node.left;
            } else {
                node.element = element;
                return root;
            }
        }

        return root;
    }

    /**
     * @param node 新插入的节点
     */
    public void afterNodeAdd(AVLNode<E> node) {
        if (node == null) return;

        while ((node = node.parent) != null) {
            if (node.isBalance()) {
                node.updateBalance();
            } else {
                AVLNode<E> grand = node;
                AVLNode<E> parent = node.getTaller();
                AVLNode<E> current = parent.getTaller();

                if (grand.left == parent && parent.left == current) {//LL
                    rotateRight(grand);

                } else if (grand.right == parent && parent.right == current) {//RR
                    rotateLeft(grand);

                } else if (grand.left == parent && parent.right == current) {//LR
                    rotateLeft(parent);
                    rotateRight(grand);
                } else {//RL
                    rotateRight(parent);
                    rotateLeft(grand);
                }
                break;
            }
        }
    }

    public void rotateLeft(AVLNode<E> node) {
        AVLNode<E> grand = node;
        AVLNode<E> parent = node.getTaller();

        parent.parent = grand.parent;
        if (parent.parent == null) {
            root = parent;
        } else {
            if(grand.isLeft()){
                grand.parent.left  = parent;
            }else{
                grand.parent.right = parent;
            }
        }
        grand.right = parent.left;
        parent.left = grand;
        grand.parent = parent;
        if (grand.right != null) {
            grand.right.parent = grand;
        }

    }

    public void rotateRight(AVLNode<E> node) {

        AVLNode<E> grand = node;
        AVLNode<E> parent = node.getTaller();

        parent.parent = grand.parent;
        if (parent.parent == null) {
            root = parent;
        } else {
            if(grand.isLeft()){
                grand.parent.left  = parent;
            }else{
                grand.parent.right = parent;
            }
        }
        grand.left = parent.right;
        parent.right = grand;
        grand.parent = parent;
        if (grand.left != null) {
            grand.left.parent = grand;
        }
    }


    public void remove(E element ) {

    }

    public void remove(AVLNode<E> node) {

    }


    public AVLNode<E> node(E element){
        AVLNode<E> node = root;
        while (node !=null){
            if(comparator.compare(element,node.element)>0){
                node = node.right;
            }else if(comparator.compare(element,node.element)<0){
                node = node.left;
            }else{
                return node;
            }
        }

        return null;
    }


    static class AVLNode<E> {

        E element;

        AVLNode<E> left;

        AVLNode<E> right;

        AVLNode<E> parent;

        int height = 1;

        public AVLNode(E element, AVLNode<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }

        public boolean hasTwoChild(){
            return left !=null && right != null;
        }

        public boolean isLeft() {
            return parent != null && this == parent.left;
        }

        public boolean isRight() {
            return parent != null && this == parent.right;
        }

        public AVLNode<E> getTaller() {
            int leftHeight = left == null ? 0 : left.height;
            int rightHeight = right == null ? 0 : right.height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return isLeft() ? left : right;
        }


        public int getBalance() {
            return (left == null ? 0 : left.height) - (right == null ? 0 : right.height);
        }

        public void updateBalance() {
            height = 1 + Math.max(left == null ? 0 : left.height, right == null ? 0 : right.height);
        }


        public boolean isBalance() {
            System.out.println(getBalance());
            return Math.abs(getBalance()) <= 1;
        }
    }


    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //测试左旋
//        tree.add(1);
//        tree.add(2);
//        tree.add(3);
//        tree.add(4);
//        tree.add(5);

        tree.add(50);
        tree.add(40);
        tree.add(60);
        tree.add(41);
        tree.add(42);

        tree.add(50);
        tree.add(55);
        tree.add(51);

        AVLNode<Integer> node = tree.node(40);

    }

}
