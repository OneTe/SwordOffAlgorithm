package Problem4;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和
 * 中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序
 * 遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * Created by wangcheng  on 2018/4/19.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class RebuildTree {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                //startpre+1，指的是前序遍历左子树的开始位置，即前序遍历根节点的下一个节点。i-startin，i指的是中序遍历根节点的位置，
                //减去中序遍历开始位置即左子树的长度。所以i-startiin+starpre是前序遍历左子树结束的位置
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);

                //从startPre位置越过左孩子及其子节点的偏移量（即i-startIn，因为startIn和i之间全是i这个元素的左孩子及其子节点）
                //再往下一个节点走（即右孩子起始点），如果写成startPre+(i-startIn)+1可能要容易看懂些
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        return root;
    }
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(reConstructBinaryTree(pre,in));
    }
}
