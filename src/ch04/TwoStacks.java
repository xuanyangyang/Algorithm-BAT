package ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 4.6
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 */
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        Stack<Integer> data = new Stack<>();
        Stack<Integer> help = new Stack<>();
        for (int i = numbers.length - 1; i >= 0; i--)
            data.push(numbers[i]);

        while (!data.empty()) {
            Integer value = data.pop();
            if (help.empty())
                help.push(value);
            else {
                if (value <= help.peek())
                    help.push(value);
                else {
                    int popNumber = 0;
                    while (!help.empty()) {
                        if (value > help.peek()) {
                            data.push(help.pop());
                            popNumber++;
                        } else
                            break;
                    }
                    help.push(value);
                    while (popNumber != 0) {
                        help.push(data.pop());
                        popNumber--;
                    }
                }
            }

        }

        while (!help.empty()) {
            data.push(help.pop());
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!data.empty()) {
            list.add(data.pop());

        }

        return list;
    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks();
        int[] data = {0, 5, 2, 7, 9, 1, 3, 2, 15};
        List<Integer> result = twoStacks.twoStacksSort(data);
        for (Integer a : result)
            System.out.print(a);
    }
}
