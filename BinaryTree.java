package com.cqupt.mauger.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树（Binary Tree）
 * 本质上是对链表和数组的一个折中，二叉树常被用于实现二叉查找树和二叉堆。
 * @author Mauger
 * @date 2018年4月4日  
 * @version 1.0
 */
public class BinaryTree {
	
    protected Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * 构造二叉树
     *        H
     *    D       G
     * B     C       F
     *   A         E
     * 
     */
    public static Node init() {
        Node a = new Node('A');
        Node b = new Node('B', null, a);
        Node c = new Node('C');
        Node d = new Node('D', b, c);
        Node e = new Node('E');
        Node f = new Node('F', e, null);
        Node g = new Node('G', null, f);
        Node h = new Node('H', d, g);
        return h; // root
    }

    /**
     * 访问节点
     */
    public static void visit(Node p) {
        System.out.print(p.getKey() + " ");
    }

    /**
     * 递归实现前序遍历
     * 前序遍历：访问根，按先序遍历左子树，按先序遍历右子树
     */
    static void preOrder(Node p) {
        if (p != null) {
            visit(p);
            preOrder(p.getLeft());
            preOrder(p.getRight());
        }
    }

    /**
     * 递归实现中序遍历
     * 中序遍历：按中序遍历左子树，访问根，按中序遍历右子树
     */
    static void inOrder(Node p) {
        if (p != null) {
            inOrder(p.getLeft());
            visit(p);
            inOrder(p.getRight());
        }
    }

    /**
     * 递归实现后序遍历
     * 后序遍历：按后序遍历左子树，按后序遍历右子树，访问根
     */
    static void postOrder(Node p) {
        if (p != null) {
            postOrder(p.getLeft());
            postOrder(p.getRight());
            visit(p);
        }
    }

    /**
     * 层次遍历
     * 通常用队列来做。先访问根节点，访问子女，再访问子女的子女（越往后的层次越低）（两个子女的级别相同）
     */
    static void levelOrder(Node p) {
        if (p == null) {
        	return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(p);
        while (queue.size() > 0) {
            Node temp = queue.poll();
            visit(temp);
            if (temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.offer(temp.getRight());
            }
        }
    }

    /**
     * 求二叉树的高度
     */
    static int height(Node tree) {
        if (tree == null) {
            return 0;
        }
        else {
            int leftTreeHeight = height(tree.getLeft());
            int rightTreeHeight = height(tree.getRight());
            return leftTreeHeight > rightTreeHeight ? leftTreeHeight + 1 : rightTreeHeight + 1;
        }
    }

    /**
     * 求二叉树的结点总数
     */
    static int nodes(Node tree) {
        if (tree == null) {
            return 0;
        }
        else {
            int left = nodes(tree.getLeft());
            int right = nodes(tree.getRight());
            return left + right + 1;
        }
    }

    /**
     * 求二叉树叶子节点的总数
     */
    static int leaf(Node tree) {
        if (tree == null) {
            return 0;
        }
        else {
            int left = leaf(tree.getLeft());
            int right = leaf(tree.getRight());
            if (tree.getLeft() == null && tree.getRight() == null) {
                return left + right + 1;
            }
            else {
                return left + right;
            }
        }
    }

    /**
     * 将二叉树所有结点的左右子树交换
     */
    static void swapTree(Node root) {
        if (root != null) {
            Node tmp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(tmp);
            swapTree(root.getLeft());
            swapTree(root.getRight());
        }
    }

    /**
     * 递归求解给定二叉树的所有叶子结点
     * @param root 给定二叉树的根结点
     * @param leaflist 给定二叉树的所有叶子结点
     */
    static void getLeafNodes(Node root, List<Node> leaflist) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                leaflist.add(root);
                return;
            }
            getLeafNodes(root.getLeft(), leaflist);
            getLeafNodes(root.getRight(), leaflist);
        }
    }

    /**
     * 递归求解给定二叉树的一条最长路径，如果有多条，输出其中一条
     * @param root 给定二叉树的根结点
     * @param longestPath 存放二叉树的最长路径上的结点
     */
    static void longestPath(Node root, List<Node> longestPath) {
        if (root != null) {
            longestPath.add(root);
            // 左右子树均空
            if (root.getLeft() == null && root.getRight() == null) {
                return;
            }

            List<Node> leftLongestPath = new ArrayList<Node>();
            List<Node> rightLongestPath = new ArrayList<Node>();
            longestPath(root.getLeft(), leftLongestPath);
            longestPath(root.getRight(), rightLongestPath);
            if (leftLongestPath.size() >= rightLongestPath.size()) {
                longestPath.addAll(leftLongestPath);
            } else if (leftLongestPath.size() < rightLongestPath.size()) {
                longestPath.addAll(rightLongestPath);

            }
        }
    }

    /**
     * main
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(init());
        System.out.print(" 前序遍历:");
        preOrder(tree.getRoot());
        System.out.println();
        System.out.print(" 中序遍历:");
        inOrder(tree.getRoot());
        System.out.println();
        System.out.print(" 后序遍历:");
        postOrder(tree.getRoot());
        System.out.println();
        System.out.println();

        System.out.println("层次遍历");
        levelOrder(tree.getRoot());
        System.out.println();
        System.out.println();
        System.out.println("叶子结点数:");
        System.out.println(leaf(tree.getRoot()));
        System.out.println("总结点数:");
        System.out.println(nodes(tree.getRoot()));
        System.out.println("树的高度:");
        System.out.println(height(tree.getRoot()));

    }

    public Node getRoot() {
        return root;
    }

}

class Node {
    private char key;
    private Node left, right;

    public Node(char key) {
        this(key, null, null);
    }

    public Node(char key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
