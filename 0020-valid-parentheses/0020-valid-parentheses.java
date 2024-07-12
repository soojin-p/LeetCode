class Solution {
      public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 여는 문자를 스택에 저장
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                // 닫는 괄호가 스택의 top과 짝이 맞으면, isValid = true
                char top = stack.pop();
                if (c == ')' && top != '(' ||
                        c == ']' && top != '[' ||
                        c == '}' && top != '{') {
                    return  false;
                } 
            }  
        }
        return stack.isEmpty();
    }
}