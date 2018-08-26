package com.chess.gamecontents;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.chess.gameplay.Moves;

public class King extends Piece {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chess.gameingredients.Piece#movement(java.lang.String)
	 */
	@Override
	public Set<String> movement(String currentPosition) {
		char alphaP = separateChar(currentPosition);
		int digitP = separateInt(currentPosition);
		setPieceType(this.getClass().getSimpleName());
		Moves moves = new Moves(alphaP, digitP);
		moves.initVarForKing();

		Set<String> addPosibilePosition = new LinkedHashSet<String>();

		addPosibilePosition.addAll(moves.moveHorizontalDiagonalExceptUpwardRight(this, addPosibilePosition));
		addPosibilePosition.addAll(moves.moveVerticalOrDiagonalWithUpwardRight(this, addPosibilePosition));
		addPosibilePosition.remove(currentPosition);

		return addPosibilePosition;
	}

}
