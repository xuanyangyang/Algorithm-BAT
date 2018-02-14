package ch04;

import java.util.Stack;

/**
 * 4.4
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Solution {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.add(value);
        if (minStack.empty())
            minStack.push(value);
        else if (minStack.peek() >= value)
            minStack.push(value);
    }

    public void pop() {
        Integer value = stack.pop();
        if (value <= minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(3);
        System.out.print(solution.min() + " ");
        solution.push(4);
        System.out.print(solution.min() + " ");
        solution.push(2);
        System.out.print(solution.min() + " ");
    }
}
