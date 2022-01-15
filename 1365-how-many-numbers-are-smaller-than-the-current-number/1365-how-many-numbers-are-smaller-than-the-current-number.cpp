class Solution {
public:
    int conter(vector<int>& nums, int key)
{
	int cnt = 0;
	for (int i = 0; i < nums.size(); i++) {
		if (key > nums[i])
			cnt++;
	}
	return cnt;
}

    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
   vector<int>ans;
	
	int key;
	//sort(tmp.begin(), tmp.end());
	
	for (int i = 0; i < nums.size(); i++){
		ans.push_back(conter(nums, nums[i]));
	}
	return ans;
    }
};