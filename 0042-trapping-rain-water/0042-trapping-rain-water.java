class Solution {
    public int trap(int[] height) {

        int water = 0;
        int left =0;
        int right = height.length - 1;

        int left_max = 0;
        int right_max = 0;

        while(left < right){
            // 왼쪽이 낮으면 왼쪽에서 이동하며 계산
            if(height[left]<height[right]){
                //left max값 갱신
                if(height[left]>= left_max){
                    left_max = height[left];
                }else{// 물의 양 계산
                    water += left_max - height[left];
                }
                left++;
            } else{// // 오른쪽이 낮으면 오른쪽에서 이동하며 계산
                if(height[right]>=right_max){
                    right_max = height[right];
                }else{
                    water += right_max - height[right];
                }
                right --;
            }
        }
        return water;
    }
}