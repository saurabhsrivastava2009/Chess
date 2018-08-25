package com.chess.gameingredients;

import java.util.Set;

public abstract class Piece {

	private String pieceType;

	/*
	 * method to get the type of piece
	 * 
	 * @return pieceType in String
	 */
	public String getPieceType() {
		return pieceType;
	}

	/*
	 * method to set the type of piece in String format, the input comes from different piece classes in
	 * the form of String
	 */
	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}

	/*
	 * abstract method to manipulate movements on the basis of Piece type and
	 * currentPosition
	 * 
	 * @returns a set of possible next moves.
	 */
	public abstract Set<String> movement(String currentPosition);

	/*
	 * method to separate integer part from the currentPosition
	 * 
	 * @return integer part
	 */
	public static int separateInt(String currentPosition) {
		return Integer.valueOf(Character.toString(currentPosition.charAt(1)));
	}

	/*
	 * method to separate character part from the currentPosition
	 * 
	 * @return character part
	 */
	public static char separateChar(String currentPosition) {
		return currentPosition.charAt(0);
	}
}
