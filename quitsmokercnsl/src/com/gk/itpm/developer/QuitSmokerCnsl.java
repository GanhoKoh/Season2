package com.gk.itpm.developer;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuitSmokerCnsl {

	public static void main(String[] args) {
		String greeting =
				" ***************QuitSmoker  y-.。o○******************\r\n" +
				" 禁煙促進コンソールアプリだよ！\r\n" +
				" たばこにいままで費やした金額と時間と本数を計算するよ\r\n" +
				" \r\n" +
				" 禁煙者は20歳からいままで使わずにすんだ金額が分るよ！\r\n" +
				" ****************************************************";

		//挨拶をする
		System.out.println(greeting);

		//入力情報から時間情報をインスタンス化
		LocalDateTime fromLdt = createFromLdt();

		//入力情報からタバコの連想配列でデータを取得する
		HashMap tobaccoData = createTobaccoData();

		//入力情報からユーザー情報を作成する
		User user = new User(fromLdt, tobaccoData);

		//後は答え（Result）を表示する機能にuser情報を渡して、呼び出して終わり
		showResult(user);
	}

	/*
	 * 禁煙開始日を受け付け全般を担当する機能
	 * 不正な入力の場合は入力を再度促す
	 *
	 */
	static LocalDateTime createFromLdt() {

		Scanner sc1 = new Scanner(System.in);
		boolean isDate = true;

		//初期化しないとreturn使えないので、一旦現在の時間でインスタンス化（苦肉の策）
		LocalDateTime fromLdt = LocalDateTime.now();

		do {
			try {
				System.out.println("禁煙開始日を入力して：[yyyy MM dd hh mm]");

				String _inputDateLine = sc1.nextLine();

				String[] inputDateLine = _inputDateLine.split(" ");

				//入力値から日付インスタンスを生成（筋肉で実行）
				fromLdt = LocalDateTime.of(
						Integer.parseInt(inputDateLine[0]),
						Integer.parseInt(inputDateLine[1]),
						Integer.parseInt(inputDateLine[2]),
						Integer.parseInt(inputDateLine[3]),
						Integer.parseInt(inputDateLine[4]));

				//入力が正しいからフラグを戻す。
				isDate = true;
			} catch (DateTimeException e) {
				System.out.println("日付としてなりたたないよ！");
				isDate = false;
			} catch (Exception e) {
				System.out.println("入力値が不正だよ！");
				isDate = false;
				e.printStackTrace();
			}

		} while (!isDate);

		return fromLdt;

	}

	/*
	 * タバコ情報入力を担当する機能
	 * 値段・1箱の本数・1日に吸う本数などの入力を受け付ける
	 * それらの情報をハッシュマップ（Key Value形式）でreturnする
	 *
	 */
	static HashMap<String, Integer> createTobaccoData() {

		Scanner sc2 = new Scanner(System.in);
		boolean isTobaccoData = true;

		HashMap<String, Integer> tobaccoData = new HashMap<String, Integer>();

		do {
			try {
				System.out.println("タバコ情報を入力して：[タバコの値段 一箱の本数 1日に吸う本数]");

				String _inputData = sc2.nextLine();
				String[] inputDataArray = _inputData.split(" ");

				tobaccoData.put("tobaccoPrice", Integer.parseInt(inputDataArray[0]));
				tobaccoData.put("tobaccoNum", Integer.parseInt(inputDataArray[1]));
				tobaccoData.put("tobaccoPerDayNum", Integer.parseInt(inputDataArray[2]));

				//タバコデータならフラグを戻す
				isTobaccoData = true;
			} catch (InputMismatchException e) {
				System.out.println("数値としてなりたたないよ！");
				isTobaccoData = false;
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("何かが違うよ！");
				isTobaccoData = false;
				e.printStackTrace();
			}

		} while (!isTobaccoData);

		return tobaccoData;
	}

	/*
	 * 結果を出力する機能
	 * 計算結果など、全ての答えを取得して出力する機能
	 *
	 */
	static void showResult(User user) {

		String tmpTimeAmnt = "あなたは%d年%dヶ月%d日%d時間%d分禁煙しました。";
		String tmpTobaccoAmnt = "あなたは%d本タバコを吸わずに済み、%d円タバコ代が浮きました。";

		HashMap<String, Integer> resultTimeAmountMap = CalcTobaccoLogic.calculateAmountTime(user);
		HashMap<String, Integer> resultTobaccoAmountMap = CalcTobaccoLogic.calculateAmountTobacco(user);

		String resultTimeAmnt = String.format(tmpTimeAmnt
				, resultTimeAmountMap.get("years")
				, resultTimeAmountMap.get("months")
				, resultTimeAmountMap.get("days")
				, resultTimeAmountMap.get("hours")
				, resultTimeAmountMap.get("minutes"));

		String resultTobaccoAmnt = String.format(tmpTobaccoAmnt
				, resultTobaccoAmountMap.get("totalTobaccoNum")
				, resultTobaccoAmountMap.get("totalMoneyAmnt"));

		System.out.println(resultTimeAmnt);
		System.out.println(resultTobaccoAmnt);

	}

}
