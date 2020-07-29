package ToOffer;

import utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,4,10,20,15,7]
 * 中序遍历 inorder = [4,9,10,3,15,20,7]
 * 返回如下的二叉树：
 *
 *       3
 *     /   \
 *   9      20
 *  / \    / \
 * 4  10  15  7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 *
 */
class buildTree {
    int[] po;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    /**
     *
     * @param pre_root 前序遍历中根节点的位置
     * @param in_left  中序遍历中左子树的开始位置
     * @param in_right 中序遍历中右子树的结束位置
     * @return
     */
    public TreeNode recur(int pre_root, int in_left, int in_right){
        if (in_left > in_right){
            return null;
        }
        TreeNode root = new TreeNode(po[pre_root]);
        //中序遍历里根节点的位置
        int i = dic.get(po[pre_root]);
        root.left = recur(pre_root + 1, in_left, i - 1);
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }
}