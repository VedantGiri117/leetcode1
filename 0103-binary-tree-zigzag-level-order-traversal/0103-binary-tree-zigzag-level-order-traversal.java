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
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null ) return res; 
        boolean ltor = true;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> ans = new ArrayList<>(Collections.nCopies(n,0));
            for(int i = 0 ; i < n ; i++){
                int index = ltor ? i : (n-1-i);
                TreeNode node = q.poll();
                ans.set(index,node.val);
                //extra traversal
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ltor = !ltor;
            res.add(ans);

        }
        return res;
    }
}