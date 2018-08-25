package com.chess.main;

/*
 * Simple Chess game.
 * Input	: "Piece-type position-on-board"	:	E.g. "Pawn E1"
 * Output	: "[Possible move]"					:	E.g. "[E2]"
 * 
 * @author	: Saurabh Srivastava
 * @date	: 21 Aug 2018
 * 
 */

import java.util.Scanner;
import java.util.Set;

import com.chess.customexception.InvalidPieceException;
import com.chess.gameingredients.*;

public class ChessGame {

	public static void main(String[] args) {
		Board b = new Board();
		Scanner sc = new Scanner(System.in);
		b.displayBoard();
		System.out.println("Enter your input:");
		String input = sc.nextLine();
		String[] inputSplit = input.split(" ");
		Set<String> allPossiblePosition = findPlayer(inputSplit[0]).movement(inputSplit[1]);
		System.out.println(allPossiblePosition);
		b.movementsOnBoard(inputSplit[1]);
		b.movementsOnBoard(allPossiblePosition);
		/*
		 * position enclosed by circular bracket is the input position and
		 * position enclosed by square bracket is the possible move a player can
		 * make depending upon the piece.
		 */
		b.displayBoard();

	}

	/*
	 * method to determine the type of piece
	 * 
	 * @return instance of the piece
	 */
	private static Piece findPlayer(String pieceType) {
		switch (pieceType) {
		case "King":
			return new King();

		case "Pawn":
			return new Pawn();

		case "Rook":
			return new Rook();

		case "Queen":
			return new Queen();

		case "Bishop":
			return new Bishop();

		default:
			throw new InvalidPieceException(pieceType + " is not a valid chess piece");

		}
	}

}
