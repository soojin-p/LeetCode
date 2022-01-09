/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
       
    vector<vector<int>> ans;
        
    queue<TreeNode*> q;
    q.push(root);
    if(!root)
        return {};

    while (!q.empty())
    {  
        vector<int>node;
        int size = q.size();
        
        for (int i = 0; i < size; i++)
        {
            TreeNode* tmp = q.front();
             node.push_back(tmp->val);
            if (tmp->left!=NULL) q.push(tmp->left);
            if (tmp->right!=NULL) q.push(tmp->right);
           
            q.pop();
            
        }
        ans.push_back(node);
    }
    return ans;
    }
};