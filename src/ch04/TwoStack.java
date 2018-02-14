package ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 4.2
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 */
public class TwoStack {
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public int[] twoStack(int[] ope, int n) {
        // write code here
        List<Integer> list = new ArrayList<>();
        for (int a : ope) {
            if (a != 0)
                add(a);
            else {
                list.add(pop());
            }
        }

        int[] result = new int[list.size()];
        int resultLen = 0;

        for(int a:list)
            result[resultLen++] = a;

        return result;
    }

    private void add(int value) {
        while (!popStack.empty()) {
            pushStack.add(popStack.pop());
        }
        pushStack.add(value);
    }

    private int pop() {
        while (!pushStack.empty()) {
            popStack.add(pushStack.pop());
        }

        return popStack.pop();
    }

    public static void main(String[] args) {
        TwoStack twoStack = new TwoStack();
        int[] data = {1, 2, 3, 0, 4, 0};
        int[] result = twoStack.twoStack(data, 6);
        for (int a : result)
            System.out.print(a);
    }
}
