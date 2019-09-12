package tree;

import common.BinaryTreeNode;

/**
 * 给定一棵二叉树和其中的一个节点，如何找出中序遍历系列的下一个节点？树中的节点除了
 * 有两个分别指向左右子节点的指针，还有一个指向父节点的指针
 *
 * Created by wangcheng on 9/10/2019
 */
public class NextNode {
    public BinaryTreeNode getNext(BinaryTreeNode node){
        if(node == null){
            return null;
        }

        BinaryTreeNode next = null;
        /*
            如果一个节点有右节点，那么它的下一个节点就是它的右子树中的最左子节点
         */
        if(node.right != null){
            BinaryTreeNode right = node.right;
            while (right.left != null){
                right = right.left;
            }
            next = right;
        }
        else if (node.parent != null){
            BinaryTreeNode curNode = node;
            BinaryTreeNode parent = node.parent;
            //如果节点刚好是它的父节点的左节点，那就不用走while循环，它的下一个节点就是父节点
            //否则向上寻找，直到找到一个是它父节点的左子节点的节点
            while (parent != null && curNode == parent.right){
                curNode = parent;
                parent = parent.parent;
            }
            next = parent;
        }
        return next;
    }
}
