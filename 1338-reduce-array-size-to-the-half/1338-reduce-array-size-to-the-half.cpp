class Solution {
public:
    int minSetSize(vector<int>& arr) {
    
	const int size = arr.size();
        
	map<int, int> cnt;
	vector<int>v;
        
	for (auto n : arr) //빈도수 계산
		cnt[n]++;
        
	for (auto p: cnt)
		v.push_back(p.second);
        
	sort(v.rbegin(), v.rend());

    int ans = 0;
	int sum = 0;
	for (auto i = 0; i < v.size(); i++)
	{
		sum += v[i];
		ans++;
		if (sum >= size/2)
		{
			break;
		}
	}
        return ans;
    }
};