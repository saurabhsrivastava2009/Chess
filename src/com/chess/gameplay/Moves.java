package com.chess.gameplay;

import java.util.LinkedHashSet;
import java.util.Set;

import com.chess.gameingredients.Bishop;
import com.chess.gameingredients.Piece;
import com.chess.gameingredients.Queen;
import com.chess.gameingredients.Rook;

/*
 * This class will handle the possible moves of Queen and Bishop as of now
 * @date - 24/08/2018
 * Next Target - This class should handle all the moves in a generic manner
 */
public class Moves {

	/*
	 * Some local variables to handle each movements
	 */
	private static int tempDigitDec;
	private static int tempDigitInc;
	private static char charDec;
	private static char charInc;
	private static int dTemp;
	private static char cTemp;
	private static int tempD;
	private static char tempC;
	private char alphaP;
	private int digitP;

	/*
	 * Initialize each variable with character and digit part of the position in
	 * order to perform manipulation
	 */
	public Moves(char alphaP, int digitP) {
		charDec = charInc = cTemp = tempC = alphaP;
		tempDigitDec = tempDigitInc = dTemp = tempD = digitP;
		this.alphaP = alphaP;
		this.digitP = digitP;
	}

	/*
	 * This method will handle upward left diagonal movement of Queen and Bishop
	 * 
	 * @returns set of possible moves
	 */
	private Set<String> moveUpwardLeftDiagonal(Set<String> addPosibilePosition, char a) {
		if (tempDigitDec > 1 && a > 'A') {
			tempDigitDec = tempDigitDec - 1;
			charDec = (char) (charDec - 1);
			if (charDec >= 'A') {
				addPosibilePosition.add(String.valueOf(charDec) + String.valueOf(tempDigitDec));
			}
		}
		return addPosibilePosition;
	}

	/*
	 * This method will handle downward right diagonal movement of Queen and
	 * Bishop
	 * 
	 * @returns set of possible moves
	 */
	private Set<String> moveDownwardRightDiagonal(Set<String> addPosibilePosition, char a) {
		if (tempDigitInc < 8 && a < 'H') {
			tempDigitInc = tempDigitInc + 1;
			charInc = (char) (charInc + 1);
			if (charInc <= 'H') {
				addPosibilePosition.add(String.valueOf(charInc) + String.valueOf(tempDigitInc));
			}
		}
		return addPosibilePosition;
	}

	/*
	 * This method will handle downward left diagonal movement of Queen and
	 * Bishop
	 * 
	 * @returns set of possible moves
	 */
	private Set<String> moveDownwardLeftDiagonal(Set<String> addPosibilePosition, char a) {
		if (dTemp < 8 && a > 'A') {
			dTemp = dTemp + 1;
			cTemp = (char) (cTemp - 1);
			if (cTemp >= 'A') {
				addPosibilePosition.add(String.valueOf(cTemp) + String.valueOf(dTemp));
			}
		}
		return addPosibilePosition;
	}

	/*
	 * This method will handle upward right diagonal movement of Queen and
	 * Bishop
	 * 
	 * @returns set of possible moves
	 */
	private Set<String> moveUpwardRightDiagonal(char alphaP, Set<String> addPosibilePosition) {
		if (tempD >= 1 && tempD <= 8 && alphaP >= 'A' && alphaP <= 'H') {
			tempD = tempD - 1;
			tempC = (char) (tempC + 1);
			if (tempC >= 'A' && tempC <= 'H' && tempD > 0 && tempD < 9) {
				addPosibilePosition.add(String.valueOf(tempC) + String.valueOf(tempD));
			}

		}
		return addPosibilePosition;
	}

	/*
	 * This method will handle all the diagonal movements apart from upward
	 * right diagonal movement
	 * 
	 * @returns set of possible moves by appending all the moves from 
	 * 1. moveUpwardLeftDiagonal 
	 * 2. moveDownwardRightDiagonal 
	 * 3. moveDownwardLeftDiagonal
	 */
	private Set<String> moveInAllDiagonalExceptUpwardRightDiagonal(Set<String> addPosibilePosition, char a) {

		// this is for upward left diagonal movement
		addPosibilePosition.addAll(moveUpwardLeftDiagonal(addPosibilePosition, a));

		// this is for downward right diagonal movement
		addPosibilePosition.addAll(moveDownwardRightDiagonal(addPosibilePosition, a));

		// this is for downward left diagonal movement
		addPosibilePosition.addAll(moveDownwardLeftDiagonal(addPosibilePosition, a));

		return addPosibilePosition;
	}

	/*
	 * main method for looping the horizontal/diagonal methods.
	 * 
	 * @return set of possible moves by appending the below combination 
	 * 1. only horizontal 
	 * 2. horizontal + diagonal (except upward right diagonal) 
	 * 3. diagonal (except upward right diagonal)
	 */
	public Set<String> moveLoopAllHorizontalDiagonalExceptUpwardRightDiagonal(Piece pieceType,
			Set<String> addPosibilePosition) {
		for (char a = (char) (alphaP - (char) (alphaP - 1)); a <= 'H'; a++) {
			if (a >= 'A' && a <= 'H') {
				if (pieceType.getPieceType().equals("Queen")) {
					// Horizontal Movement
					addPosibilePosition.add(String.valueOf(a) + String.valueOf(digitP));
					// Move in all diagonal Positions except upward Right
					// diagonal
					addPosibilePosition.addAll(moveInAllDiagonalExceptUpwardRightDiagonal(addPosibilePosition, a));
				} else if (pieceType.getPieceType().equals("Rook")) {
					// Horizontal Movement
					addPosibilePosition.add(String.valueOf(a) + String.valueOf(digitP));
				} else if (pieceType.getPieceType().equals("Bishop")) {
					// Move in all diagonal Positions except upward Right
					// diagonal
					addPosibilePosition.addAll(moveInAllDiagonalExceptUpwardRightDiagonal(addPosibilePosition, a));
				}
			}
		}

		return addPosibilePosition;
	}
	
	/*
	 * method to handle vertical/upward right diagonal movement
	 * @returns appended list of
	 * 1. vertical movement
	 * 2. diagonal movement
	 */
	public Set<String> moveLoopAllVerticalOrDiagonalMovementInUpwardRight(Piece pieceType,
			Set<String> addPosibilePosition) {
		if (digitP != 1) {
			for (int j = digitP - (digitP - 1); j <= 8; j++) {
				if (pieceType.getPieceType().equals("Queen")) {
					// Vertical movement to handle position apart from A1 to H1
					addPosibilePosition.add(String.valueOf(alphaP) + String.valueOf(j));
					// this if is for upward Right diagonal movement
					addPosibilePosition.addAll(moveUpwardRightDiagonal(alphaP, addPosibilePosition));
				} else if (pieceType.getPieceType().equals("Rook")) {
					// Vertical Movement for position other than A1 to H1
					addPosibilePosition.add(String.valueOf(alphaP) + String.valueOf(j));
				} else if (pieceType.getPieceType().equals("Bishop")) {
					// this if is for upward Right diagonal movement
					addPosibilePosition.addAll(moveUpwardRightDiagonal(alphaP, addPosibilePosition));
				}

			}
		} else if (pieceType.getPieceType().equals("Queen") || pieceType.getPieceType().equals("Rook")) {
			for (int j = 2; j <= 8; j++) {
				// Vertical Movement for position from A1 to H1
				addPosibilePosition.add(String.valueOf(alphaP) + String.valueOf(j));
			}
		}
		return addPosibilePosition;
	}
}
