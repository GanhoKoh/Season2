package com.gk.itpm.developer;

import java.time.Period;

public class CalcTobaccoLogic {

	//時間の差を返すメソッド
	//from ～ toまでの時間量を返す
	static Period calculateNonSmokeDays(User user) {

		return Period.between(user.getFromLd(), user.getToLd());

	}
}
