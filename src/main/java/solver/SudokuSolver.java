package solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {

    private Integer[][] sudokuBoard;
    private final boolean[][] fixedCells;

    public SudokuSolver(Integer[][] sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        this.fixedCells = new boolean[9][9];
        initializeFixedCells();
    }

    private void initializeFixedCells() {
        for (int row = 0; row < sudokuBoard.length; row++) {
            for (int col = 0; col < sudokuBoard[row].length; col++) {
                // Se a célula não for nula, é uma célula fixa
                if (sudokuBoard[row][col] != null) {
                    fixedCells[row][col] = true;
                } else {
                    fixedCells[row][col] = false;
                }
            }
        }
    }

    public boolean solveBoard(){
        for (int i = 0; i < sudokuBoard.length; i++){
            for (int j = 0; j < sudokuBoard[i].length; j++){
                if (fixedCells[i][j]){
                    continue;
                }

                if (sudokuBoard[i][j] == null){
                    List<Integer> availableNums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                    isValid(availableNums, i, j);
                    for (Integer num : availableNums){
                        sudokuBoard[i][j] = num;
                        if (solveBoard()){
                            return true;
                        }
                        sudokuBoard[i][j] = null;
                    }
                return false;
                }
            }
        }
        return true;
    }

    private void isValid(List<Integer> availableNums, int row, int column){
        checkSameColumn(availableNums, row);
        checkSameRow(availableNums, column);
        checkSameBlock(availableNums, row, column);
    }

    private void checkSameColumn(List<Integer> availableNums, int checkingColumn){
        for (int row = 0; row <sudokuBoard.length; row++){
            availableNums.remove(sudokuBoard[checkingColumn][row]); // Unnecessary to check as if input == null, nothing will be removed from availableNums
        }
    }

    private void checkSameRow(List<Integer> availableNums, int checkingRow){
        for (int column = 0; column < sudokuBoard.length; column++){
            availableNums.remove(sudokuBoard[column][checkingRow]);
        }
    }

    private void checkSameBlock(List<Integer> availableNums, int row, int column){
        // Verificar se o número já está no mesmo bloco 3x3
        int blockRow = row - row % 3;
        int blockCol = column - column % 3;
        for (int i = blockRow; i < blockRow + 3; i++) {
            for (int j = blockCol; j < blockCol + 3; j++) {
                availableNums.remove(sudokuBoard[i][j]);
            }
        }
    }
}
