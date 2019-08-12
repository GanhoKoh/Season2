package com.gk.itpm.developer;

import java.time.Duration;
import java.time.Period;
import java.util.HashMap;

public class CalcTobaccoLogic {

	/*
	 * このビジネスロジックのみで利用。ユーザーのPeriodを返す
	 * 年月日までを計算する。時分はDurationで実施する。
	 *
	 */
	private static Period calculatePeriod(User user) {
		return Period.between(user.getFromLd(), user.getToLd());
	}

	/*
	 * このビジネスロジックのみで利用。ユーザーのDurationを返す。
	 * 年月日はPeriodでやっているのでここでは時分の計算のみをする
	 *
	 */
	private static Duration calculateDuration(User user) {
		return Duration.between(user.getFromLdt().toLocalTime(), user.getToLdt().toLocalTime());
	}

	/*
	 * このビジネスロジックのみで利用。ユーザーの吸ったタバコ総本数を返す
	 * UserのLocalDateTime（時間量）と1日の本数から経過日数分の本数を計算する
	 *
	 */
	private static int calculateTotalTobaccoNum(User user) {

		//経過総合計分を算出
		int howManyMinutes = (int) Duration.between(user.getFromLdt(), user.getToLdt()).toMinutes();

		//何分に1本吸うのか割り出す
		int perSmokeMinutes = 1440 / user.getTobaccoPerDayNum();

		return howManyMinutes / perSmokeMinutes;
	}

	/*
	 * このビジネスロジックのみで利用。ユーザーの吸ったタバコ送金額を返す
	 * Userのタバコ情報から、経過時間を利用して金額を割り出す
	 *
	 */
	private static int calculateTotalMoneyAmnt(User user) {

		//吸ったタバコの総本数を確認
		int totalTobaccoNum = calculateTotalTobaccoNum(user);

		//1本の値段を算出する
		int perTobaccoPrice = user.getTobaccoPrice() / user.getTobaccoNum();

		return totalTobaccoNum * perTobaccoPrice;
	}

	/*
	 * 他から呼び出されるキモとなるビジネスロジック「時間量」計算を担当する
	 * KeyValue形式のHashMapで年・月・日・時・分をreturnする。
	 *
	 */
	public static HashMap<String, Integer> calculateAmountTime(User user) {
		//変換用のHashMapを用意する
		HashMap<String, Integer> resultTimeAmntMap = new HashMap<String, Integer>();

		//Keyを宣言する
		String years = "years";
		String months = "months";
		String days = "days";
		String hours = "hours";
		String minutes = "minutes";

		Period period = calculatePeriod(user);
		Duration duration = calculateDuration(user);
		//もし開始時刻が現在時刻より後だったらつじつまを合わせる必要あり
		if(duration.isNegative()) {
			//マイナスなら1日追加する
			duration.plusDays(1);

			//追加した分periodをマイナスする。これでプラマイゼロと言える
			period.minusDays(1);
		}

		//PeriodとDurationそれぞれの値をセットしていく
		resultTimeAmntMap.put(years, period.getYears());
		resultTimeAmntMap.put(months, period.getMonths());
		resultTimeAmntMap.put(days, period.getDays());
		resultTimeAmntMap.put(hours, (int) duration.toHours());
		resultTimeAmntMap.put(minutes, (int) duration.toMinutes() % 60);

		return resultTimeAmntMap;
	}

	/*
	 * 他から読み出されるキモとなるビジネスロジック「タバコ量・金額」計算を担当する
	 * KeyValue形式のHashMapで総本数・総金額を返す。
	 *
	 */
	public static HashMap<String, Integer> calculateAmountTobacco(User user) {
		//変換用のHashMapを用意する
		HashMap<String, Integer> resultTobaccoAmntMap = new HashMap<String, Integer>();

		//keyを宣言する
		String totalTobaccoNumKey = "totalTobaccoNum";
		String TotalMoneyAmntKey = "totalMoneyAmnt";

		//吸った総本数を割り出す
		int totalTobaccoNum = calculateTotalTobaccoNum(user);
		//かかった総金額を割り出す
		int totalMoneyAmnt = calculateTotalMoneyAmnt(user);

		//keyValueに値をセットする
		resultTobaccoAmntMap.put(totalTobaccoNumKey, totalTobaccoNum);
		resultTobaccoAmntMap.put(TotalMoneyAmntKey, totalMoneyAmnt);

		return resultTobaccoAmntMap;
	}
}
