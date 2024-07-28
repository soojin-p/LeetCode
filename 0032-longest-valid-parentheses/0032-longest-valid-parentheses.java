import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // 문자열을 순회
    // 여는 문자일경우, 큐 추가
    // 닫는 문자일경우
    // 길이 계산
    public int longestValidParentheses(String s) {
        int maxLength = 0;
      
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { 
                stack.push(i);
            } else if (c == ')') { // 닫는 문자일 경우
                stack.pop(); // 짝 추출
                if (stack.isEmpty()) {
                    
                   stack.push(i);
                } else { // 유효한 괄호
                    int start =  stack.peek();
                   maxLength = Math.max(maxLength, i -start);
                }
            }
        }

        return maxLength;
    }
}