package com.chess.gameingredients;

import java.util.LinkedHashSet;
import java.util.Set;

public class Queen extends Player {

	@Override
	public Set<String> movement(String position) {

		Set<String> set = new LinkedHashSet<String>();
		char alphaP = separatChar(position);
		int digitP = separateInt(position);
		int tempDigitDec = digitP;
		int tempDigitInc = digitP;
		char charDec = alphaP;
		char charInc = alphaP;
		int dTemp = digitP;
		char cTemp = alphaP;
		for (char a = (char) (alphaP - (char) (alphaP - 1)); a <= 'H'; a++) {
			if (a >= 'A' && a <= 'H') {
				set.add(String.valueOf(a) + String.valueOf(digitP));
				if (tempDigitDec > 1 && a > 'A') {
					tempDigitDec = tempDigitDec - 1;
					charDec = (char) (charDec - 1);
					if (charDec >= 'A') {
						set.add(String.valueOf(charDec) + String.valueOf(tempDigitDec));
					}
				}
				if (tempDigitInc < 8 && a < 'H') {
					tempDigitInc = tempDigitInc + 1;
					charInc = (char) (charInc + 1);
					if (charInc <= 'H') {
						set.add(String.valueOf(charInc) + String.valueOf(tempDigitInc));
					}
				}
				if (dTemp < 8 && a > 'A') {
					dTemp = dTemp + 1;
					cTemp = (char) (cTemp - 1);
					if (cTemp >= 'A') {
						set.add(String.valueOf(cTemp) + String.valueOf(dTemp));
					}
				}
			}
		}
		if (digitP != 1) {
			tempDigitDec = digitP;
			tempDigitInc = digitP;
			charDec = alphaP;
			charInc = alphaP;
			for (int j = digitP - (digitP - 1); j <= 8; j++) {
				set.add(String.valueOf(alphaP) + String.valueOf(j));
				if (tempDigitInc >= 1 && tempDigitInc <= 8 && alphaP > 'A' && alphaP < 'H') {
					tempDigitDec = tempDigitDec - 1;
					charDec = (char) (charDec + 1);
					if (charDec >= 'A' && charDec <= 'H' && tempDigitDec > 0 && tempDigitDec < 9) {
						set.add(String.valueOf(charDec) + String.valueOf(tempDigitDec));
					}
				}
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
