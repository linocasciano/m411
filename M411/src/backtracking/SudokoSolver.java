package backtracking;

import java.util.HashSet;

public class SudokoSolver {
	
	// test comments

	int[][] board;
	int boardsize = 9;
	boolean solutionfound = false;

	public SudokoSolver() {
		initBoard();
	}

	private void initBoard() {
		board = new int[boardsize][boardsize];
		board[0][0] = 2;
		board[0][2] = 8;
		board[0][4] = 4;
		board[0][5] = 7;
		board[0][8] = 1;
		
		board[1][0] = 1;
		board[1][5] = 3;
		board[1][7] = 9;
		board[1][8] = 8;
		
		board[2][1] = 5;
		board[2][4] = 8;
		board[2][8] = 7;
		
		board[3][3] = 6;
		board[3][4] = 7;
		board[3][6] = 1;
		board[3][7] = 4;
		
		board[4][0] = 6;
		board[4][2] = 3;
		board[4][3] = 4;
		board[4][7] = 2;
		
		board[5][0] = 9;
		board[5][1] = 1;
		board[5][3] = 3;
		board[5][5] = 8;
		board[5][8] = 6;
		
		board[6][1] = 8;
		board[6][2] = 6;
		board[6][4] = 5;
		board[6][5] = 2;
		
		board[7][1] = 3;
		board[7][2] = 2;
		board[7][3] = 8;
		board[7][5] = 6;
		board[7][6] = 7;
		
		board[8][2] = 1;
		board[8][4] = 3;
		board[8][6] = 6;
		board[8][8] = 2;
	}

	public void solve() {
		int[][] solution = new int[boardsize][boardsize];
		for (int i = 0; i < boardsize; i++) {
			for (int j = 0; j < boardsize; j++) {
				solution[i][j] = board[i][j];
			}
		}
		solve(solution, 0, 0);
	}

	private void solve(int[][] solution, int row, int column) {
		if (row == boardsize) {
			System.out.println("Found solution");
			solutionfound = true;
			printSolution(solution);
			return;
		}
		System.out.println("Finding solution for [" + row + "][" + column + "]");
		//printSolution(solution);

		// only try a solution for the position that are not set from the beginning
		// try the numbers from 1 to 9 as a solution
		for (int n = 1; n < 10; n++) {
			if (solutionfound) { break; }
			// no predefined number on the board
			if (board[row][column] == 0) {
				solution[row][column] = n;
			}
			System.out.println("Trying with [" + n + "] for [" + row + "][" + column + "]");
			// check whether we have found a solution
			if (isConsitent(solution)) {
				if (column == boardsize - 1) { // we have reached the end of a row
					solve(solution, row + 1, 0); // continue on the next row
				} else {
					solve(solution, row, column + 1); // we still work in the same row, advance the column
				}
			} else {
				// reset to zero for the backtracking case
				solution[row][column] = 0;
			}
		}
	}

	private void printSolution(int[][] solution) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(solution[i][j]);
				if (j == board.length - 1) {
					System.out.println();
				} else {
					System.out.print(",");
				}
			}
		}
		System.out.println("========================");
	}

	private boolean isConsitent(int[][] solution) {
		// row consitency
		if (!checkRowConsitency(solution)) {
			return false;
		}

		// column consitency
		if (!checkColumnConsitency(solution)) {
			return false;
		}
		;

		// field consitency
		if (!checkFieldConsitency(solution)) {
			return false;
		}

		return true;
	}

	private boolean checkFieldConsitency(int[][] solution) {
		HashSet<Integer> used = new HashSet<Integer>();
		for (int i = 1; i <= boardsize; i++) {
			int[] g = getGrid(i, solution);
			used.clear();
			for (int j = 0; j < boardsize; j++) {
				if (g[j] != 0) {
					if (!used.contains(g[j])) {
						used.add(g[j]); // the number has been used
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	private int[] getGrid(int i, int[][] solution) {
		int[] a = new int[boardsize];
		switch (i) {
		case 1:
			a[0] = solution[0][0];
			a[1] = solution[0][1];
			a[2] = solution[0][2];
			a[3] = solution[1][0];
			a[4] = solution[1][1];
			a[5] = solution[1][2];
			a[6] = solution[2][0];
			a[7] = solution[2][1];
			a[8] = solution[2][2];
			break;
		case 2:
			a[0] = solution[0][3];
			a[1] = solution[0][4];
			a[2] = solution[0][5];
			a[3] = solution[1][3];
			a[4] = solution[1][4];
			a[5] = solution[1][5];
			a[6] = solution[2][3];
			a[7] = solution[2][4];
			a[8] = solution[2][5];
			break;
		case 3:
			a[0] = solution[0][6];
			a[1] = solution[0][7];
			a[2] = solution[0][8];
			a[3] = solution[1][6];
			a[4] = solution[1][7];
			a[5] = solution[1][8];
			a[6] = solution[2][6];
			a[7] = solution[2][7];
			a[8] = solution[2][8];
			break;
		case 4:
			a[0] = solution[3][0];
			a[1] = solution[3][1];
			a[2] = solution[3][2];
			a[3] = solution[4][0];
			a[4] = solution[4][1];
			a[5] = solution[4][2];
			a[6] = solution[5][0];
			a[7] = solution[5][1];
			a[8] = solution[5][2];
			break;
		case 5:
			a[0] = solution[3][3];
			a[1] = solution[3][4];
			a[2] = solution[3][5];
			a[3] = solution[4][3];
			a[4] = solution[4][4];
			a[5] = solution[4][5];
			a[6] = solution[5][3];
			a[7] = solution[5][4];
			a[8] = solution[5][5];
			break;
		case 6:
			a[0] = solution[3][6];
			a[1] = solution[3][7];
			a[2] = solution[3][8];
			a[3] = solution[4][6];
			a[4] = solution[4][7];
			a[5] = solution[4][8];
			a[6] = solution[5][6];
			a[7] = solution[5][7];
			a[8] = solution[5][8];
			break;
		case 7:
			a[0] = solution[6][0];
			a[1] = solution[6][1];
			a[2] = solution[6][2];
			a[3] = solution[7][0];
			a[4] = solution[7][1];
			a[5] = solution[7][2];
			a[6] = solution[8][0];
			a[7] = solution[8][1];
			a[8] = solution[8][2];
			break;
		case 8:
			a[0] = solution[6][3];
			a[1] = solution[6][4];
			a[2] = solution[6][5];
			a[3] = solution[7][3];
			a[4] = solution[7][4];
			a[5] = solution[7][5];
			a[6] = solution[8][3];
			a[7] = solution[8][4];
			a[8] = solution[8][5];
			break;
		case 9:
			a[0] = solution[6][6];
			a[1] = solution[6][7];
			a[2] = solution[6][8];
			a[3] = solution[7][6];
			a[4] = solution[7][7];
			a[5] = solution[7][8];
			a[6] = solution[8][6];
			a[7] = solution[8][7];
			a[8] = solution[8][8];
			break;
		}
		return a;
	}

	private boolean checkColumnConsitency(int[][] solution) {
		HashSet<Integer> used = new HashSet<Integer>();
		for (int i = 0; i < solution.length; i++) {
			used.clear();
			for (int j = 0; j < solution[0].length; j++) {
				if (solution[j][i] != 0) {
					if (!used.contains(solution[j][i])) {
						used.add(solution[j][i]);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean checkRowConsitency(int[][] solution) {
		HashSet<Integer> used = new HashSet<Integer>();
		for (int i = 0; i < solution.length; i++) {
			used.clear();
			for (int j = 0; j < solution[0].length; j++) {
				if (solution[i][j] != 0) {
					if (!used.contains(solution[i][j])) {
						used.add(solution[i][j]); // the number is used
					} else {
						return false;
					}
				}
			}
		}
		return true;

	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 1; j++) {
				System.out.print(board[i][j]);
				if (j < board.length - 2) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SudokoSolver sudokoSolver = new SudokoSolver();
		sudokoSolver.solve();
	}

}
