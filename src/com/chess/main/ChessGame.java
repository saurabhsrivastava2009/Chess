package com.chess.main;

import java.util.Scanner;
import java.util.Set;

import com.chess.gameingredients.*;

public class ChessGame {

	public static void main(String[] args) {
		Board b = new Board();
		Scanner sc = new Scanner(System.in);
		b.displayBoard();
		System.out.println("Enter your input:");
		String input = sc.nextLine();
		String[] inputSplit=input.split(" ");
		Set<String> set =findPlayer(inputSplit[0]).movement(inputSplit[1]);
		System.out.println(set);
		b.movementsOnBoard(inputSplit[1]);
		b.movementsOnBoard(set);
		b.displayBoard();
		
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
		else if(playerType.equals("Queen")){
			return new Queen();
		}
		throw new InvalidPlayer(playerType +" is not a valid chess piece");
	}

}
