import java.util.*;

public class Board {
    Cell[][] board = new Cell[3][3];

    public void setBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cell c = new Cell();
                board[i][j] = c;
                board[i][j].printCell();
            }
            System.out.println("");
        }
    }

    public void printBoard() {
        for (Cell[] x : board) {
            for (Cell y : x) {
                y.printCell();
            }
            System.out.println("");
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getStatus() == CellStatus.EMPTY)
                    return true;
            }
        }
        return false;
    }

    public void update(int x, int y, CellStatus c) {
        if (x > 3 || y > 3)
        {
            System.out.println("Wrong position!");
            System.out.println("Please enter a valid position!");
            Scanner scanner = new Scanner(System.in);
            int newX = scanner.nextInt();
            int newY = scanner.nextInt();
            update(newX, newY, c);
        }
        if (board[x - 1][y - 1].getStatus() == CellStatus.EMPTY) {
            board[x - 1][y - 1].setStatus(c);
        } else {
            System.out.println("Cell not empty!");
            System.out.println("Please enter a valid position!");
            Scanner scanner = new Scanner(System.in);
            int newX = scanner.nextInt();
            int newY = scanner.nextInt();
            update(newX, newY, c);
        }
    }

    public boolean check() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].getStatus() == board[i][1].getStatus())
                    && (board[i][1].getStatus() == board[i][2].getStatus())
                    && ((board[i][0].getStatus() == CellStatus.O) || (board[i][0].getStatus() == CellStatus.X)))
                return true;
            if ((board[0][i].getStatus() == board[1][i].getStatus())
                    && (board[1][i].getStatus() == board[2][i].getStatus())
                    && ((board[0][i].getStatus() == CellStatus.O) || (board[0][i].getStatus() == CellStatus.X)))
                return true;
            if ((board[0][0].getStatus() == board[1][1].getStatus())
                    && (board[1][1].getStatus() == board[2][2].getStatus())
                    && ((board[0][0].getStatus() == CellStatus.O) || (board[0][0].getStatus() == CellStatus.X)))
                return true;
            if ((board[2][0].getStatus() == board[1][1].getStatus())
                    && (board[1][1].getStatus() == board[0][2].getStatus())
                    && ((board[2][0].getStatus() == CellStatus.O) || (board[2][0].getStatus() == CellStatus.X)))
                return true;
        }
        return false;
    }
}
