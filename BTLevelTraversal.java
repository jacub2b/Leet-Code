import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * @param
 */
class BTLevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> nextLevelNodes = new ArrayDeque<>();
        Queue<TreeNode> currentLevelNodes = new LinkedList<TreeNode>();
        List<Integer> currentLevelResult = new ArrayList<Integer>();
        ArrayList<Integer> bal = new ArrayList<>();

        currentLevelNodes.add(root);

        while(!currentLevelNodes.isEmpty()) {
            while(!currentLevelNodes.isEmpty()) {
                TreeNode current = currentLevelNodes.poll();
                currentLevelResult.add(current.val);
                if (current.left != null) nextLevelNodes.add(current.left);
                if (current.right != null) nextLevelNodes.add(current.right);
            }

            result.add(currentLevelResult);
            currentLevelNodes.addAll(nextLevelNodes);
            nextLevelNodes = new LinkedList<TreeNode>();
            currentLevelResult = new ArrayList<Integer>();
        }

        return result;
    }
}