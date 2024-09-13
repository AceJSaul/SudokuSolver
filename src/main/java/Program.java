import board.SudokuBoard;
import solver.SudokuSolver;

public class Program {

    public static void main(String[] args){

        SudokuBoard gameBoard = new SudokuBoard();
        Integer[][] testBoard = {{null, 9, null, null, null, 1, null, null, null},
                            {null, null, null, 5, 2, null, 9, null, null},
                            {null, null, null, 3, null, null, 5, 4, null},
                            {1, 8, null, null, 4, null, null, 2, null},
                            {null, 2, null, 1, null, null, 4, null, 5},
                            {3, null, 7, 2, null, null, null, null, 8},
                            {null, null, null, null, 5, 6, null, null, 7},
                            {null, null, null, null, 1, null, null, null, null},
                            {null, null, 1, 4, null, 8, null, 9, null}};
        gameBoard.setBoard(testBoard);
        var solver = new SudokuSolver(testBoard);
        solver.solveBoard();

        gameBoard.printBoard();

    }
}
