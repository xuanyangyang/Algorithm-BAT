package ch13;

/**
 * 13.4
 * A与B做游戏。 在一个n*m的矩阵中的出发点是（1，m），终点是（n,1），规则是只能向左移动一格，向下一格或向左下移动一格，先走到终点的为winner。 A先走。
 * 给定两个整数n和m，请返回最后的获胜者的名字(A或B)。
 * 测试样例：
 * 5 3
 * 返回：B
 */
public class Game {
    public char getWinner(int n, int m) {
        // write code here
        // 最优策略是两个人每次共走2格，
        // 如果A向左下2移动一格，相当于移动2格，此时B也应该向左下移动，总共是4格
        if (m % 2 != 0 && n % 2 != 0)
            return 'B';// // 此时B距离终点只有1格
        else
            return 'A';
    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.getWinner(2, 2));
    }
}
