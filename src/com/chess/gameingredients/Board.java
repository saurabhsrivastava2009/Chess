package com.chess.gameingredients;

import java.util.LinkedHashSet;
import java.util.Set;

public class Board {
	private static String[][] chessBoard = new String[8][8];

	/*
	 * this return the last position present in the board
	 */
	public String getLastBoardPosition(){
		return chessBoard[7][7];
	}
	
	/*
	 * this returns the first position present in the board
	 */
	public String getFirstBoardPosition(){
		return chessBoard[0][0];
	}
	
	public Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chessBoard[i][j] = Character.toString((char) (j + 65)) + String.valueOf(i + 1);
			}
		}
	}

	public void displayBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(chessBoard[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	public void movementsOnBoard(Set<String> set) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (String s : set) {
					if (chessBoard[i][j].equals(s)) {
						chessBoard[i][j] = "[" + chessBoard[i][j] + "]";
					}
				}
			}
		}

	}

	public void movementsOnBoard(String currentPosition) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (chessBoard[i][j].equals(currentPosition)) {
					chessBoard[i][j] = "(" + chessBoard[i][j] + ")";
				}

			}
		}

	}
}
