package com.ds.stu.BiaryTree;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class BiaryTree {
    private List<Node>Nodes= new ArrayList<>();
    private Node root;
    protected Stack<Node>NodeST;
    //构造函数
    public BiaryTree(Integer len) {
    }
    //节点值的输入
    public void NodeIn(Integer len) {
        int idx = 0;
        System.out.println("本类以下为满二叉树的节点值输入，输入" + len + "个节点值（直接按回车表示空节点）");
        System.out.println("广度优先输入");
        Scanner sc = new Scanner(System.in);
        while (len > 0) {
            len--;
            idx++;
            System.out.print("id = " + idx + " : ");
            String input = sc.nextLine(); // 读取整行输入

            Integer val;
            if (input.isEmpty()) {
                // 如果输入为空，则将 val 设置为 null
                val = null;
            } else {
                try {
                    val = Integer.parseInt(input); // 尝试将输入转换为整数
                } catch (NumberFormatException e) {
                    val = null; // 如果转换失败，则将 val 设置为 null
                }
            }
            Nodes.add(new Node(val));
        }

        /**
         * 构建起二叉树
         * root 已知
         * {@code Node x=Nodes.get(i)}
         * 则 x.left=Nodes.get(2*i+1),x.right=Nodes.get(2*i+2)
         * 若 x.left==null ,则x.left.IsEmpty=true
         */
        if (Nodes.size() > 0) root = Nodes.get(0);
        for (Integer i = 0; i < Nodes.size(); i++) {
            Node cur = Nodes.get(i);
            if (cur.val != null) { // 只为非空节点设置子节点
                if (2 * i + 1 < Nodes.size()) {
                    cur.left = Nodes.get(2 * i + 1);
                }
                if (2 * i + 2 < Nodes.size()) {
                    cur.right = Nodes.get(2 * i + 2);
                }
            }
        }
    }
//    前序遍历 递归实现
    public void DFS_TLR() {
        DFS_TLR(root);
    }
    public void DFS_TLR(Node root) {
        if (root== null) return;
        System.out.print(root.toString()+' ');
        DFS_TLR(root.left);
        DFS_TLR(root.right);
    }
//    中序遍历 递归实现
    public void DFS_LTR() {
        DFS_LTR(root);
    }
    public void DFS_LTR(Node root) {
        if (root== null) return;
        DFS_LTR(root.left);
        System.out.print(root.toString()+' ');
        DFS_LTR(root.right);
    }
//    后序遍历 递归实现
    public void DFS_LRT() {
        DFS_LRT(root);
    }
    public void DFS_LRT(Node root) {
        if (root== null) return;
        DFS_LRT(root.left);
        DFS_LRT(root.right);
        System.out.print(root.toString()+' ');
    }

//    前序遍历 栈实现
    public void New_TLR() {
        if (root == null) return;
        NodeST.push(root);
        while (NodeST.size()!=0) {
            Node tmp = NodeST.pop();
            System.out.println(tmp.toString());
            if (tmp.left!= null) NodeST.push(tmp.left);
            if (tmp.right!= null) NodeST.push(tmp.right);
        }
    }
//    中序遍历 栈实现
    public void New_LTR(Node root) {
        if (root == null) return;
        NodeST.push(root);
        while (NodeST.size()!=0) {

        }
    }
//    后序遍历 栈实现
    public void New_LRT(Node root) {if (root == null) return;
    }
//    展示图片并保存为图片

    public void GetPicture(String name){
        GetPicture(root,name);
    }
    private void GetPicture(Node root,String name) {
        // 创建一个图形界面以展示二叉树
        JFrame frame = new JFrame("Binary Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // 创建一个面板来绘制树
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTree(g, root, getWidth() / 2, 30, 100);
            }
        };

        frame.add(panel);
        frame.setVisible(true);

        // 保存为图片
        BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        panel.paint(g2d);
        g2d.dispose();
        try {
            ImageIO.write(image, "png", new File(name+".jpg"));
            System.out.println("图片已保存为 binary_tree.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 绘制树的递归方法
    private void drawTree(Graphics g, Node node, int x, int y, int gap) {
        if (node == null) return;

        // 绘制当前节点
        g.drawString(node.toString(), x, y);

        // 计算子节点的位置
        if (node.left != null) {
            g.drawLine(x, y, x - gap, y + 50); // 画左边的线
            drawTree(g, node.left, x - gap, y + 50, gap / 2); // 递归绘制左子树
        }
        if (node.right != null) {
            g.drawLine(x, y, x + gap, y + 50); // 画右边的线
            drawTree(g, node.right, x + gap, y + 50, gap / 2); // 递归绘制右子树
        }
    }
}