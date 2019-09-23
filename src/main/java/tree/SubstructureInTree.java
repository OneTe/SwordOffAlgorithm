package tree;

import common.TreeNode;

/**
 * // 26：树的子结构
 * // 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 *
 * Created by wangcheng on 9/19/2019
 */

public class SubstructureInTree {
    public boolean hasSubTree(TreeNode root1, TreeNode root2){
        boolean res = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                res = doesTree1HaveTree2(root1, root2);
            }
            if(!res){
                res = hasSubTree(root1.left, root2);
            }
            if(!res){
                res = hasSubTree(root2.right, root2);
            }
        }
        return res;
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if (root2 == null) {
           return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
