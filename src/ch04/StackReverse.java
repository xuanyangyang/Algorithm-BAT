package ch04;

import java.util.Stack;

/**
 * 4.5
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 */
public class StackReverse {
    Stack<Integer> stack = new Stack<>();

    public int[] reverseStack(int[] A, int n) {
        // write code here
        for (int i = n - 1; i >= 0; i--)
            stack.add(A[i]);

        reverse();

        int index = 0;
        while (!stack.empty())
            A[index++] = stack.pop();

        return A;
    }

    // 反转栈
    public void reverse() {
        if (stack.empty())
            return;
        int i = getBottom();
        reverse();
        stack.push(i);
    }

    // 得到栈底元素
    public int getBottom() {
        int result = stack.pop();
        if (stack.empty())
            return result;
        else {
            int last = getBottom();
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        StackReverse stackReverse = new StackReverse();
        int[] data = {4, 3, 2, 1};
        int[] result = stackReverse.reverseStack(data, 4);
        for (int a : result)
            System.out.print(a);
    }
}
