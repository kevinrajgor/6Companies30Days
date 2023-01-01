/*You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String i : tokens) {
            if (!set.contains(i))
                st.push(Integer.valueOf(i));
            else {
                int a = st.pop(), b = st.pop();
                if (i.equals("+"))
                    st.push(a + b);
                else if (i.equals("-"))
                    st.push(b - a);
                else if (i.equals("*"))
                    st.push(a * b);
                else
                    st.push(b / a);
            }
        }
        return st.peek();
    }
}