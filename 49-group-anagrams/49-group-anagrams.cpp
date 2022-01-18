class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
	unordered_map<string, vector<string>> hash_table;

		for(int i = 0; i < strs.size(); i++)
		{
			string tmp = strs[i];
			sort(strs[i].begin(), strs[i].end());
			hash_table[strs[i]].push_back(tmp);
		}

		for (auto i = hash_table.begin(); i != hash_table.end(); i++) {
			ans.push_back(i->second);
		}
        return ans;
    }
};