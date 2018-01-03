package DataStructure;

import java.util.Stack;

/**
 * Created by xingtianyi on 1/3/18.
 */
public class QueueByStack {
    public class MyQueue {

        public Stack<Integer> st1;
        public Stack<Integer> st2;

        public MyQueue() {
            // do intialization if necessary


            this.st1 = new Stack<Integer>();
            this.st2 = new Stack<Integer>();

        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            // write your code here
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
            this.st1.push(element);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }

            return st2.pop();

        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }

            return st2.peek();
        }
    }
}
