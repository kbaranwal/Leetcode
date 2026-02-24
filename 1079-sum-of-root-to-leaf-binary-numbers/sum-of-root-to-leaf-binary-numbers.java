class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int current) {
        if (node == null) return 0;
        
        // Left shift + add current node value
        current = current * 2 + node.val;
        
        // Leaf node -> return current value
        if (node.left == null && node.right == null) {
            return current;
        }
        
        // Left aur Right ka sum return karo
        return dfs(node.left, current) + dfs(node.right, current);
    }
}