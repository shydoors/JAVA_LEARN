package com.ds.stu.BiaryTree;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        /**
        System.out.println("请输入满二叉树的节点个数");
        Integer len = new java.util.Scanner(System.in).nextInt();
        BiaryTree tree = new BiaryTree(len);
        tree.DFS_LRT();
        */
        Integer len=7;
        BiaryTree tree = new BiaryTree(len);
        tree.NodeIn(len);
        System.out.println("递归实现 前序遍历");
        tree.DFS_TLR();
        System.out.println("递归实现 中序遍历");
        tree.DFS_LTR();
        System.out.println("递归实现 后序遍历");
        tree.DFS_LRT();
        tree.GetPicture("xxx");
    }
}