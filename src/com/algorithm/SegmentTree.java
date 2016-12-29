package com.algorithm;
/**
 * Created by chuck7 on 16/12/21.
 */
public class SegmentTree {
    class TreeNode {
        TreeNode leftChild, rightChild;
        int start, end;
        int min;
        public TreeNode(int s, int e) {
            start = s;
            end = e;
        }
    }
    public TreeNode build(int[] nums, int left, int right) {
        TreeNode root = new TreeNode(left, right);
        if (left == right) {
            //如果范围的左边界等于右边界了,比如[5,5]这样的范围其实就是一个叶子节点了,也就是原数组里的元素了
            root.min = nums[left];
        } else {
            //否则就递归的去构造左子树和右子树
            int mid = left + (right - left)/2;
            root.leftChild = build(nums, left, mid);
            root.rightChild = build(nums, mid+1, right);
            //递归回来了,求两子树的最小值作为当前节点的最小值
            root.min = Math.min(root.leftChild.min, root.rightChild.min);
        }
        return root;
    }
    //更新原数组中下标为i的元素的值为val
    private void update(TreeNode root, int i, int val) {
        if (root.start == root.end) {
            //如果是叶子节点,直接更新
            root.min = val;
        } else {
            int mid = root.start + (root.end-root.start)/2;
            if (i <= mid) {
                //如果i在左子树, 那就深入左子树去进行更新
                update(root.leftChild, i, val);
            } else {
                //如果i在右子树, 那就深入右子树去进行更新
                update(root.rightChild, i, val);
            }
            //不管你更新的是左子树还是右子树
            //我最后要确保一下,我这个节点的值是正确的
            root.min = Math.min(root.leftChild.min, root.rightChild.min);
        }
    }
    //查询操作
    //查询数组中区间[i,j]的最小值
    private int min(TreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            //如果当前区间跟想要求的区间正好吻合
            return root.min;
        } else {
            int mid = root.start + (root.end - root.start)/2;
            if (j <= mid) {
                //如果区间是左子树区间的子集
                return min(root.leftChild, i, j);
            } else if (i > mid) {
                //如果区间是右子树区间的子集
                return min(root.rightChild, i, j);
            } else {
                //如果区间[i,j]横跨了左右子树
                //比如左子树[0-4],右子树[5,9],而你要求的是[3,6]
                //那我就在左子树找出[3,4],右子树找出[5,6],然后求一下最小值,得到结果
                return Math.min(min(root.leftChild, i, root.leftChild.end) , min(root.rightChild, root.rightChild.start, j));
            }
        }
    }
}
