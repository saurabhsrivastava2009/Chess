package com.chess.gameingredients;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class King extends Player {

	@Override
	public Set<String> movement(String position) {
		char alphaP = separatChar(position);
		int digitP = separateInt(position);
		Set<String> set = new LinkedHashSet<String>();
		if (digitP != 8) {
			for (char a = (char) (alphaP - 1); a <= alphaP + 1; a++) {
				if (a >= 'A' && a <= 'H') {
					set.add(String.valueOf(a) + String.valueOf(digitP + 1));
					set.add(String.valueOf(a) + String.valueOf(digitP));
				}
			}
			if (digitP != 1) {
				for (int j = digitP - 1; j <= digitP + 1; j++) {
					if ((char) (alphaP - 1) >= 'A') {
						set.add(String.valueOf((char) (alphaP - 1)) + String.valueOf(j));
					}
					set.add(String.valueOf(alphaP) + String.valueOf(j));
					if ((char) (alphaP + 1) <= 'H') {
						set.add(String.valueOf((char) (alphaP + 1)) + String.valueOf(j));
					}
				}
			}
		} else {
			for (int j = digitP - 1; j <= digitP + 1; j++) {
				if (j == 9) {
					break;
				}
				if ((char) (alphaP - 1) >= 'A') {
					set.add(String.valueOf((char) (alphaP - 1)) + String.valueOf(j));
				}
				set.add(String.valueOf(alphaP) + String.valueOf(j));
				if ((char) (alphaP + 1) <= 'H') {
					set.add(String.valueOf((char) (alphaP + 1)) + String.valueOf(j));
				}
			}
		}
		set.remove(position);

		return set;
	}

}
