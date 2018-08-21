package com.chess.gameingredients;

import java.util.Set;

public abstract class Player {
	public Board board = new Board();
	
	public abstract Set<String> movement(String position);
	
	public int separateInt(String position){
		for(int i=0;i<position.length();i++){
			char alpha = position.charAt(i);
			if(Character.isDigit(alpha)){
				return Integer.valueOf(Character.toString(alpha));
			}
		}
		return -1;
	}
	
	public char separatChar(String position){
		for(int i=0;i<position.length();i++){
			char alpha = position.charAt(i);
			if(!Character.isDigit(alpha)){
				return alpha;
			}
		}
		return 'a';
	}
}
