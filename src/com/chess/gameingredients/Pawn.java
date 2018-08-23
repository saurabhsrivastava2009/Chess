package com.chess.gameingredients;

import java.util.LinkedHashSet;
import java.util.Set;

public class Pawn extends Piece {

	/*
	 * (non-Javadoc)
	 * @see com.chess.gameingredients.Piece#movement(java.lang.String)
	 */
	@Override
	public Set<String> movement(String currentPosition) {
		Set<String> set = new LinkedHashSet<String>();
		char alphaP = separateChar(currentPosition);
		int digitP = separateInt(currentPosition);
		setPieceTypeInString(this.getClass().getSimpleName());
		if (digitP != 8) {
			set.add(String.valueOf(alphaP) + String.valueOf(digitP + 1));
		}
		set.remove(currentPosition);
		return set;
		// return null;
	}

}
