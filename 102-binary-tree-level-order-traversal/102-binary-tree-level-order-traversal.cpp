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
       
        vector<vector<int>> res;
        //Node를 담을 큐
        queue<TreeNode*> q_node;
        if (root == NULL) {
            return {};
        }
        //root가 null이 아니라면 queue에 넣습니다.
        q_node.push(root);
        while (!q_node.empty()) {
            vector<int> level_nodes;
            int size = q_node.size();
            for (int i = 0; i < size; i++) {
                //tmp는 임시 노드입니다.
                TreeNode* tmp = q_node.front();
                //임시 노드를 벡터에 넣습니다.
                level_nodes.push_back(tmp->val);
                //left가 비어있지 않으면 큐에 넣고
                if (tmp->left != NULL) {
                    q_node.push(tmp->left);
                }
                //right가 비어있지 않으면 마찬가지로 큐에 넣습니다.
                if (tmp->right != NULL) {
                    q_node.push(tmp->right);
                }
                // Don't forget to pop q_node INSIDE the for loop after visit it.
                q_node.pop();
            }
           
            res.push_back(level_nodes);
        }
        return res;
    }
};