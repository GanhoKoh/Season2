package com.gk.itpm.developer;

public class CalcLogic {

	static boolean validateEngingeerRank(String engineerRank) {
		if("A".compareToIgnoreCase(engineerRank) == 0
			||"B".compareToIgnoreCase(engineerRank) == 0
			||"C".compareToIgnoreCase(engineerRank) == 0) {
			return true;
		} else {
			return false;
		}
	}

	static boolean validateCost(String cost) {
		try {
			Integer.parseInt(cost);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	static int calcuSalary(String engineerRank, int cost) {
		if("A".compareToIgnoreCase(engineerRank) == 0) {
			return (int) (cost * 0.6);
		} else if ("B".compareToIgnoreCase(engineerRank) == 0) {
			return (int) (cost * 0.55);
		} else {
			return (int) (cost * 0.5);
		}
	}

}
