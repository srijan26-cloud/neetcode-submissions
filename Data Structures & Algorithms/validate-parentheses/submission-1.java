class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack();
        for(Character i: s.toCharArray()){
            if(i == '{' || i == '(' || i == '[')
                st.push(i);
            else {
                if(st.isEmpty())
                    return false; 
                char top = st.pop();
                if(i == '}' && (top != '{'))
                    return false;
                if(i == ']' && (top != '['))
                    return false;
                if(i == ')' && (top != '('))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
