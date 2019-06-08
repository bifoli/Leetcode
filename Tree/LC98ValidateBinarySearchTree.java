/**
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * for example:
 *            10
 *          /    \
 *         5      20
 * 
 * for the left node, the value must be less than 10 and more than -infinite: (-infinite, 10)
 * for the right node, the value must be more than 10 and less than +infinite: (10, +infinite)
 * 
 * */
class Solution {
    public boolean isValidBST(TreeNode root) {
        //assume the scope of root.value is (-infinite, +infinite)
        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isBSTHelper(TreeNode node, long min, long max) {
        if(node == null) {
            return true;
        }
        
        //if root.value is not in the range of (-infinite, +infinite), return false
        if(node.val >= max || node.val <= min) {
            return false;
        }else {
            return isBSTHelper(node.left, min, node.val) && isBSTHelper(node.right, node.val, max);
        }
    }
}