import java.util.*;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");
        boolean play = true;
        Scanner scanner = new Scanner(System.in);
        Board boardGame = new Board();
        boardGame.setBoard();
        while (play) {
            while (boardGame.isEmpty()) {
                System.out.println("Player 1");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                boardGame.update(x, y, CellStatus.X);
                boardGame.printBoard();
                if (boardGame.check()) {
                    System.out.println("Player 1 win!");
                    System.out.println("Wanna play again?");
                    System.out.println("(0/1)");
                    int check = scanner.nextInt();
                    if (check == 0)
                        play = false;
                    else
                        boardGame.setBoard();
                    break;
                }
                if (!boardGame.isEmpty())
                    break;
                System.out.println("Player 2");
                x = scanner.nextInt();
                y = scanner.nextInt();
                boardGame.update(x, y, CellStatus.O);
                boardGame.printBoard();
                if (boardGame.check()) {
                    System.out.println("Player 2 win!");
                    System.out.println("Wanna play again?");
                    System.out.println("(0/1)");
                    int check = scanner.nextInt();
                    if (check == 0)
                        play = false;
                    else
                        boardGame.setBoard();
                    break;
                }
            }
            if (!boardGame.isEmpty()) {
                System.out.println("A draw");
                System.out.println("Wanna play again?");
                System.out.println("(0/1)");
                int check = scanner.nextInt();
                if (check == 0)
                    play = false;
                else
                    boardGame.setBoard();
            }
        }
    }
}