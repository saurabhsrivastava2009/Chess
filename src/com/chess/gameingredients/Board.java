package com.chess.gameingredients;

public class Board {
	private String[][] position = new String[8][8];
	
	public Board(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				position[i][j]= Character.toString((char)(j+65))+String.valueOf(i+1);
			}
		}
	}
	
	public String[][] getBoard(){
		return position;
	}
	
	public void displayBoard(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(position[i][j]+" ");//= Character.toString((char)(j))+String.valueOf(i);
			}
			System.out.println("");
		}
	}
}
