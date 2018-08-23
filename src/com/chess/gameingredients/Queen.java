package com.chess.gameingredients;

import java.util.LinkedHashSet;
import java.util.Set;

import com.chess.gameplay.Moves;

public class Queen extends Piece {

	/*
	 * (non-Javadoc)
	 * @see com.chess.gameingredients.Piece#movement(java.lang.String)
	 */
	@Override
	public Set<String> movement(String currentPosition) {

		Set<String> addPosibilePosition = new LinkedHashSet<String>();
		
		/*
		 * Method to separate current position of piece into character and decimal part.
		 * alphaP holds the character part of the current position
		 * digitP holds the decimal part of the current position
		 * Splitting starts here-----------------------------------
		 */
		char alphaP = separateChar(currentPosition);
		int digitP = separateInt(currentPosition);
		//Ends here------------------------------------------------
		setPieceTypeInString(this.getClass().getSimpleName());
		Moves moves = new Moves(alphaP, digitP);
		addPosibilePosition.addAll(moves.moveLoopAllHorizontalDiagonalExceptUpwardRightDiagonal(this, addPosibilePosition));
		addPosibilePosition.addAll(moves.moveLoopAllVerticalOrDiagonalMovementInUpwardRight(this, addPosibilePosition));
		
		addPosibilePosition.remove(currentPosition);
		return addPosibilePosition;

	}

}
