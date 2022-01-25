package Sudoku;

import java.util.*;

public class GeneratePuzzle {

	public static int[][] presolvedarray = new int[9][9];
	public static int[][] testarray = new int[9][9];
	public static int[][] forsolve = new int[9][9];

	public void main() {

		int loopiterator = 1, suede1, suede2;
		int removecount = 0;
		int validq = 1;
		int attemptcounter = 0;

		generatepuz();
		//value 1 into this method will switch the random rows
		randomgen(1);
		//value 0 into this method will switch the random columns
		randomgen(0);

		Random rnd = new Random();

		int possiblevals[] = { 0, 3, 6 };
		for (int i = 0; i < 2; i++) {

			suede1 = possiblevals[rnd.nextInt(possiblevals.length)];

			do {
				suede2 = possiblevals[rnd.nextInt(possiblevals.length)];
			} while (suede1 == suede2);

			// 2 random numbers (0,3,or 6) are sent to group-swap methods

			if (loopiterator == 1) {
				row3change(suede1, suede2);
			}

			else {
				column3change(suede1, suede2);
			}

			loopiterator = 0;
		}

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				testarray[i][j] = presolvedarray[i][j];

			}
		}

		attemptcounter = 0;

		while (validq == 1) {

			removecount = 0;

			// removing 40 cells at random
			while (removecount < 40) {

				int rowremove = rnd.nextInt(9);
				int columnremove = rnd.nextInt(9);

				if (testarray[rowremove][columnremove] != 0) {

					testarray[rowremove][columnremove] = 0;
					removecount++;

				}
			}

			for (int i = 0; i < 9; i++) {

				for (int j = 0; j < 9; j++) {

					forsolve[i][j] = testarray[i][j];

				}
			}

			// testing to see if puzzle is solvable

			doSudokuSolve(testarray);

			if (Arrays.equals(testarray, presolvedarray) == true) {

				validq = 0;
			}

			else {

				// maximum of 1000 attempts at 40 removals (arbitrary)
				// so that puzzle generation does not take too long.

				if (attemptcounter > 1000) {
					validq = 0;
				} else {
					validq = 1;
					attemptcounter++;
				}

			}

		}

	}

	// generating a solved puzzle that abides by game rules.

	public static void generatepuz() {

		int valueinsert;
		int valueholder = 1;

		for (int i = 0; i < 9; i++) {
			valueinsert = valueholder;
			for (int j = 0; j < 9; j++) {
				if (valueinsert <= 9) {
					presolvedarray[i][j] = valueinsert;
					valueinsert++;
				} else {
					valueinsert = 1;
					presolvedarray[i][j] = valueinsert;
					valueinsert++;
				}
			}
			valueholder = valueinsert + 3;
			if (valueinsert == 10)
				valueholder = 4;
			if (valueholder > 9)
				valueholder = (valueholder % 9) + 1;
		}
	}

	public static void randomgen(int roworcolumnq) {

		int rowcol1, rowcol2;
		int max = 2;
		int min = 0;

		// picks two rows or columns to be swapped at random (to improve uniqueness)

		Random rnd = new Random();

		for (int i = 0; i < 3; i++) {

			rowcol1 = rnd.nextInt(max - min + 1) + min;

			do {

				rowcol2 = rnd.nextInt(max - min + 1) + min;
			} while (rowcol1 == rowcol2);

			max += 3;
			min += 3;

			if (roworcolumnq == 1) {

				switchrow(rowcol1, rowcol2);
			}

			else if (roworcolumnq == 0) {

				switchcolumn(rowcol1, rowcol2);
			}

		}
	}

	public static void switchrow(int row1, int row2) {
		int temporal;
		for (int j = 0; j < 9; j++) {
			temporal = presolvedarray[row1][j];
			presolvedarray[row1][j] = presolvedarray[row2][j];
			presolvedarray[row2][j] = temporal;
		}
	}

	public static void switchcolumn(int column1, int column2) {
		int temporal;
		for (int j = 0; j < 9; j++) {
			temporal = presolvedarray[j][column1];
			presolvedarray[j][column1] = presolvedarray[j][column2];
			presolvedarray[j][column2] = temporal;
		}
	}

	public static void row3change(int rowblocktochange1, int rowblocktochange2) {

		// two 3x9 rows to be swapped at random (to improve uniqueness)

		int temporal;
		for (int n = 1; n <= 3; n++) {
			for (int i = 0; i < 9; i++) {
				temporal = presolvedarray[rowblocktochange1][i];
				presolvedarray[rowblocktochange1][i] = presolvedarray[rowblocktochange2][i];
				presolvedarray[rowblocktochange2][i] = temporal;
			}
			rowblocktochange1++;
			rowblocktochange2++;
		}
	}

	public static void column3change(int columnblocktochange1, int columnblocktochange2) {

		// two 3x9 columns to be swapped at random (to improve uniqueness)

		int temporal;
		for (int n = 1; n <= 3; n++) {
			for (int i = 0; i < 9; i++) {
				temporal = presolvedarray[i][columnblocktochange1];
				presolvedarray[i][columnblocktochange1] = presolvedarray[i][columnblocktochange2];
				presolvedarray[i][columnblocktochange2] = temporal;
			}
			columnblocktochange1++;
			columnblocktochange2++;
		}
	}

	public static boolean doSudokuSolve(int[][] matrix) {

		// this method will try to solve the generated puzzle (with 40 holes)

		int[] singlearray = existsAsHole(matrix);

		if (singlearray[0] == -1) {
			return true;
		}

		int row = singlearray[0];
		int col = singlearray[1];

		for (int i = 1; i <= 9; i++) {
			if (isValidMove(matrix, row, col, i)) {

				matrix[row][col] = i;
				boolean verify = doSudokuSolve(matrix);
				if (verify == true) {
					return true;
				}
				matrix[row][col] = 0;

			}
		}
		return false;
	}

	public static int[] existsAsHole(int[][] matrix) {

		int[] singlearray = new int[2];// getting position of the first of 40 holes
		singlearray[0] = -1;
		singlearray[1] = -1;

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix.length; column++) {
				if (matrix[row][column] == 0) {
					singlearray[0] = row;
					singlearray[1] = column;
					return singlearray;
				}
			}
		}

		return singlearray;

	}

	public static boolean isAlreadyUsedRow(int[][] matrix, int row, int num) {
		
		
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[row][i] == num) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAlreadyUsedColumn(int[][] matrix, int col, int num) {
		
		//tests if value (num) already appears in that given column)
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][col] == num) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAlreadyUsedSuperbox(int[][] matrix, int row1Start, int col1Start, int num) {
		
		//tests if value (num) already appears in that given 3x3 box)

		for (int row = 0; row < 3; row++)
			for (int column = 0; column < 3; column++)
				if (matrix[row + row1Start][column + col1Start] == num) {
					return true;
				}

		return false;

	}

	public static boolean isValidMove(int[][] verifymatrix, int row, int column, int iterationint) {

		return (!isAlreadyUsedColumn(verifymatrix, column, iterationint)
				&& !isAlreadyUsedRow(verifymatrix, row, iterationint)
				&& !isAlreadyUsedSuperbox(verifymatrix, row - row % 3, column - column % 3, iterationint));

	}

	public static boolean isValidMove(int row, int column, int[][] sudokuverifyarray, int jawnint) {

		int i, j;

		for (i = 0; i < row; i++) {
			if (sudokuverifyarray[i][column] == 1)
				return false;
		}
			

		for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (sudokuverifyarray[i][j] == 1)
				return false;
		}
			

		for (i = row, j = column; i >= 0 && j < jawnint; j++, i--) {
			if (sudokuverifyarray[i][j] == 1)
				return false;
		}
			

		return true;

	}
}
