package com.feng.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class Q257 {


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node2.left = node4;
        node4.left = node8;
        node2.right = node5;

        node1.right = node3;
        node3.left = node6;

        printTreeNode(node1);
    }

    private static void printTreeNode(TreeNode node1) {
        List<String> result = new ArrayList<>();
        dfs(node1, "", result);
        System.out.println(result);
    }

    private static void dfs(TreeNode root, String s, List<String> result) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(s);
            if (root.left == null && root.right == null) {
                sb.append(root.val);
                result.add(sb.toString());
                return;
            }
            sb.append(root.val).append("->");
            dfs(root.left, sb.toString(), result);
            dfs(root.right, sb.toString(), result);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
