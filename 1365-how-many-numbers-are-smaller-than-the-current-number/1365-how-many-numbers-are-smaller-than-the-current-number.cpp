class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
     vector<int>ans;
	vector<int>tmp = nums;
	
	//sort(tmp.begin(), tmp.end());
	
	for (int i = 0; i < tmp.size(); i++){
		int cnt = 0;

		for (int j = 0; j < tmp.size(); j++) {
			if (nums[i] > tmp[j])
				cnt++;
		}
		ans.push_back(cnt);
	}
	return ans;
    }
};