package DataStructure;

import java.util.Stack;

/**
 * Created by xingtianyi on 1/3/18.
 */
public class MinStack {

    public Stack<Integer> st;
    public Stack<Integer> st2;

    public MinStack() {
        // do intialization if necessary
        this.st = new Stack<Integer>();
        this.st2 = new Stack<Integer>();

    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        st.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        return st.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        int min = Integer.MAX_VALUE;
        while(!st.isEmpty()){
            int curr = st.pop();
            if(curr < min){
                min = curr;
            }
            st2.push(curr);
        }

        while(!st2.isEmpty()){
            st.push(st2.pop());
        }

        return min;
    }
}
