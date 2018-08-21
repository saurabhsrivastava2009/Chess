package com.chess.gameingredients;

import java.util.LinkedHashSet;
import java.util.Set;

public class Pawn extends Player {

	@Override
	public Set<String> movement(String position) {
		Set<String> set= new LinkedHashSet<String>();
		char alphaP = separatChar(position);
		int digitP = separateInt(position);
		if(digitP!=8){
			set.add(String.valueOf(alphaP)+String.valueOf(digitP+1));
		}
		set.remove(position);
		return set;
		//return null;
	}

	

}
