package com.sanlin.zawgyidetectorlib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZGDetector {
	static final String zawgyiRegex = "\u1031\u103b" // e+medial ra
			// beginning e or medial ra
			+ "|^\u1031|^\u103b"
			// independent vowel, dependent vowel, tone , medial ra wa ha (no ya
			// because of 103a+103b is valid in unicode) , digit ,
			// symbol + medial ra
			+ "|[\u1022-\u1030\u1032-\u1039\u103b-\u103d\u1040-\u104f]\u103b"
			// end with asat
			+ "|\u1039$"
			// medial ha + medial wa
			+ "|\u103d\u103c"
			// medial ra + medial wa
			+ "|\u103b\u103c"
			// consonant + asat + ya ra wa ha independent vowel e dot below
			// visarga asat medial ra digit symbol
			+ "|[\u1000-\u1021]\u1039[\u101a\u101b\u101d\u101f\u1022-\u102a\u1031\u1037-\u1039\u103b\u1040-\u104f]"
			// II+I II ae
			+ "|\u102e[\u102d\u103e\u1032]"
			// ae + I II
			+ "|\u1032[\u102d\u102e]"
			// I II , II I, I I, II II
			+ "|[\u102d\u102e][\u102d\u102e]"
			// U UU + U UU
			+ "|[\u102f\u1030][\u102f\u1030]"
			// tall aa short aa
			+ "|[\u102b\u102c][\u102b\u102c]"
			// shan digit + vowel
			+ "|[\u1090-\u1099][\u102b-\u1030\u1032\u1037\u103c-\u103e]"
			// consonant + medial ya + dependent vowel tone asat
			+ "|[\u1000-\u102a]\u103a[\u102c-\u102e\u1032-\u1036]"
			// independent vowel dependent vowel tone medial digit + e
			+ "|[\u1023-\u1030\u1032-\u103a\u1040-\u104f]\u1031"
			// other shapes of medial ra + consonant not in Shan consonant
			+ "|[\u107e-\u1084][\u1001\u1003\u1005-\u100f\u1012-\u1014\u1016-\u1018\u101f]"
			// u + asat
			+ "|\u1025\u1039"
			// eain-dray
			+ "|[\u1081\u1083]\u108f"
			// short na + stack characters
			+ "|\u108f[\u1060-\u108d]"
			// I II ae dow bolow above + asat typing error
			+ "|[\u102d-\u1030\u1032\u1036\u1037]\u1039"
			// aa + asat awww
			+ "|\u102c\u1039"
			// ya + medial wa
			+ "|\u101b\u103c"
			// e + zero + vowel
			+ "|\u1031?\u1040[\u102b\u105a\u102d-\u1030\u1032\u1036-\u1038]"
			// e + seven + vowel
			+ "|\u1031?\u1047[\u102c-\u1030\u1032\u1036-\u1038]";

	public int countZawgyiPattern(String input) {
		int found = 0;
		Pattern zawgyiPattern = Pattern.compile(zawgyiRegex);
		Matcher matcher = zawgyiPattern.matcher(input);
		while (matcher.find()) {

			found++;
		}

		return found;
	}

	public boolean isZawgyi(String input) {
		Pattern zawgyiPattern = Pattern.compile(zawgyiRegex);
		Matcher matcher = zawgyiPattern.matcher(input);
		return matcher.find();
	}

	public int countZawgyiPatternAndShowPattern(String input) {
		int found = 0;
		Pattern zawgyiPattern = Pattern.compile(zawgyiRegex);
		Matcher matcher = zawgyiPattern.matcher(input);
		while (matcher.find()) {

			found++;
			System.out.println("found " + found + " : " + matcher.group());
		}

		System.out.println(found);

		return found;
	}

}
