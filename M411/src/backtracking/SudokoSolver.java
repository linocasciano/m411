package backtracking;

public class SudokoSolver {
	
	int[][] board;
	
	public SudokoSolver() {
		initBoard();
	}
	
	private void initBoard() {
		board = new int[9][9];
		board[0][1] = 1;
	}
	
	public void printBoard() {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length-1; j++) {
				System.out.print(board[i][j]);
				if (j<board.length-2) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		SudokoSolver sudokoSolver = new SudokoSolver();
		sudokoSolver.printBoard();
	}

}
