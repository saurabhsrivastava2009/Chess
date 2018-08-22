package com.chess.gameingredients;

import java.util.LinkedHashSet;
import java.util.Set;

public class Rook extends Player {

	@Override
	public Set<String> movement(String position) {
		Set<String> set = new LinkedHashSet<String>();
		char alphaP = separatChar(position);
		int digitP = separateInt(position);
		for (char a = (char) (alphaP - (char) (alphaP - 1)); a <= 'H'; a++) {
			if (a >= 'A' && a <= 'H') {
				set.add(String.valueOf(a) + String.valueOf(digitP));
			}
		}
		if (digitP != 1) {
			for (int j = digitP - (digitP - 1); j <= 8; j++) {
				set.add(String.valueOf(alphaP) + String.valueOf(j));
			}
		} else {
			for (int j = 2; j <= 8; j++) {
				set.add(String.valueOf(alphaP) + String.valueOf(j));
			}
		}

		set.remove(position);
		return set;
	}

}
