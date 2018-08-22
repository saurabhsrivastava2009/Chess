package com.chess.main;

import java.util.Scanner;

import com.chess.gameingredients.*;

public class ChessGame {

	public static void main(String[] args) {
		Board b = new Board();
		Scanner sc = new Scanner(System.in);
		b.displayBoard();
		System.out.println("Enter your input:");
		String input = sc.nextLine();
		String[] inputSplit=input.split(" ");
		System.out.println(findPlayer(inputSplit[0]).movement(inputSplit[1]));
		
	}

	private static Player findPlayer(String playerType) {
		if(playerType.equals("King")){
			return new King();
		}
		else if(playerType.equals("Pawn")){
			return new Pawn();
		}
		else if(playerType.equals("Rook")){
			return new Rook();
		}
		throw new InvalidPlayer(playerType +" is not a valid chess piece");
	}

}
