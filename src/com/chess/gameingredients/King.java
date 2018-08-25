package com.chess.gameingredients;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class King extends Piece {

	/*
	 * (non-Javadoc)
	 * @see com.chess.gameingredients.Piece#movement(java.lang.String)
	 */
	@Override
	public Set<String> movement(String currentPosition) {
		char alphaP = separateChar(currentPosition);
		int digitP = separateInt(currentPosition);
		setPieceType(this.getClass().getSimpleName());
		Board board = new Board();
		
		int lastDigitOnBoard = separateInt(board.getLastBoardPosition());
		char lastCharOnBoard = separateChar(board.getLastBoardPosition());
		char firstCharOnBoard = separateChar(board.getFirstBoardPosition());
		int firstDigitOnBoard = separateInt(board.getFirstBoardPosition());
		Set<String> set = new LinkedHashSet<String>();
		if (digitP != lastDigitOnBoard) {
			for (char a = (char) (alphaP - 1); a <= alphaP + 1; a++) {
				if (a >= firstCharOnBoard && a <= lastCharOnBoard) {
					set.add(String.valueOf(a) + String.valueOf(digitP + 1));
					set.add(String.valueOf(a) + String.valueOf(digitP));
				}
			}
			if (digitP != firstDigitOnBoard) {
				for (int j = digitP - 1; j <= digitP + 1; j++) {
					if ((char) (alphaP - 1) >= firstCharOnBoard) {
						set.add(String.valueOf((char) (alphaP - 1)) + String.valueOf(j));
					}
					set.add(String.valueOf(alphaP) + String.valueOf(j));
					if ((char) (alphaP + 1) <= lastCharOnBoard) {
						set.add(String.valueOf((char) (alphaP + 1)) + String.valueOf(j));
					}
				}
			}
		} else {
			for (int j = digitP - 1; j <= digitP + 1; j++) {
				if (j == lastDigitOnBoard+1) {
					break;
				}
				if ((char) (alphaP - 1) >= firstCharOnBoard) {
					set.add(String.valueOf((char) (alphaP - 1)) + String.valueOf(j));
				}
				set.add(String.valueOf(alphaP) + String.valueOf(j));
				if ((char) (alphaP + 1) <= lastCharOnBoard) {
					set.add(String.valueOf((char) (alphaP + 1)) + String.valueOf(j));
				}
			}
		}
		set.remove(currentPosition);

		return set;
	}

}
