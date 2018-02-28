package ch13;

/**
 * 你和你的朋友正在玩棋子跳格子的游戏，而棋盘是一个由n个格子组成的长条，你们两人轮流移动一颗棋子，每次可以选择让棋子跳1-3格，先将棋子移出棋盘的人获得胜利。我们知道你们两人都会采取最优策略，现在已知格子数目，并且初始时棋子在第一格由你操作。请你计算你是否能获胜。
 * 给定格子的数目n(n为不超过300的正整数)。返回一个整数，1代表能获胜，0代表不能获胜。
 * 测试样例：
 * 3
 * 返回：1
 */
public class Jump {
    public int checkWin(int n) {
        // write code here
        return (n - 1) % 4 == 0 ? 0 : 1;
    }
}