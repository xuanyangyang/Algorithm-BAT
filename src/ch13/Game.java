package ch13;

public class Game {
    public char getWinner(int n, int m) {
        // write code here
        char[][] dp = new char[n][m];
        int row = 0;
        int col = 0;

        return 'A';
    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.getWinner(2, 2));
    }
}
