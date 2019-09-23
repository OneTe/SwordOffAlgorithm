package tree;

import common.TreeNode;

/**
 * // 27：二叉树的镜像
 * // 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * Created by wangcheng on 9/19/2019
 */
public class MirrorOfBinaryTree {
    public void MirrorRecursively(TreeNode node){
        if(node == null  || (node.left == null) && (node.right == null)){
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if(node.left != null){
            MirrorRecursively(node.left);
        }

        if(node.right != null){
            MirrorRecursively(node.right);
        }
    }
}
