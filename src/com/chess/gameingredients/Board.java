package com.chess.gameingredients;

import java.util.LinkedHashSet;
import java.util.Set;

public class Board {
	private String[][] position = new String[8][8];

	public Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				position[i][j] = Character.toString((char) (j + 65)) + String.valueOf(i + 1);
			}
		}
	}

	public void displayBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(position[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	public void movementsOnBoard(Set<String> set) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (String s : set) {
					if (position[i][j].equals(s)) {
						position[i][j] = "[" + position[i][j] + "]";
					}
				}
			}
		}

	}

	public void movementsOnBoard(String pos) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (position[i][j].equals(pos)) {
					position[i][j] = "(" + position[i][j] + ")";
				}

			}
		}

	}
}
