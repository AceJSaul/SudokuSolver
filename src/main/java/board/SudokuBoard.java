package board;

public class SudokuBoard {

    private Integer[][] board = new Integer[9][9];

    public SudokuBoard(){
    }

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] board){
        this.board = board;
    }

    public void printBoard(){
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[i].length; j++){
                if (board[i][j] == null){
                    System.out.print("_");
                }
                else{System.out.print(board[i][j]);
                }
                if ((j+1) % 3 == 0 && j < 8){
                    System.out.print("|");
                }
            }
            if ((i+1) % 3 == 0) System.out.println("\n-----------");
            else System.out.println();

        }
    }
}
