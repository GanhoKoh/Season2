package com.gk.itpm.developer;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuitSmokerCnsl {

	public static void main(String[] args) {
		String greeting = " ***************QuitSmoker  y-.。o○******************\r\n" +
				" 禁煙促進コンソールアプリだよ！\r\n" +
				" たばこにいままで費やした金額と時間と本数を計算するよ\r\n" +
				" \r\n" +
				" 禁煙者は20歳からいままで使わずにすんだ金額が分るよ！\r\n" +
				" ****************************************************";

		//挨拶をする
		System.out.println(greeting);

		//時間情報を入力をする機能
		//入力情報から時間情報をインスタンス化
		LocalDateTime fromLdt = createFromLdt();

		//タバコ情報を入力する機能
		//連想配列でそれぞれの値を取得するようにする
		HashMap tobaccoData = createTobaccoData();

		//表示をする
		System.out.println("Hello world");

	}

	static LocalDateTime createFromLdt() {

		Scanner sc1 = new Scanner(System.in);
		boolean isDate = true;

		//初期化しないとreturn使えないので、一旦現在の時間でインスタンス（苦肉の策）
		LocalDateTime fromLdt = LocalDateTime.now();

		do {
			try {
				System.out.println("禁煙開始日を入力して：[yyyy MM dd hh mm]");

				String _inputDateLine = sc1.nextLine();

				String[] inputDateLine = _inputDateLine.split(" ");

				//入力値から日付インスタンスを生成（筋肉で実行）
				fromLdt = LocalDateTime.of(
						Integer.parseInt(inputDateLine[0]), Integer.parseInt(inputDateLine[1]),
						Integer.parseInt(inputDateLine[2]), Integer.parseInt(inputDateLine[3]),
						Integer.parseInt(inputDateLine[4]));

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

	static HashMap<String, Integer> createTobaccoData() {

		Scanner sc2 = new Scanner(System.in);
		boolean isTobaccoData = true;

		HashMap<String, Integer> tobaccoData = new HashMap<String, Integer>();

		do {
			try {
				System.out.println("タバコ情報を入力して：[タバコの値段 一箱の本数 1日に吸う本数]");

				String _inputData = sc2.nextLine();
				String[] inputData = _inputData.split(" ");

				tobaccoData.put("tobaccoPrice", value);
				tobaccoData.put("tobaccoNum", value);
				tobaccoData.put("tobaccoPerDayNum", value);

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


		tobaccoData.put("tobaccoPrice", tobaccoDataArray[0]);
		tobaccoData.put("tobaccoNum", tobaccoDataArray[1]);
		tobaccoData.put("tobaccoPerDayNum", tobaccoDataArray[2]);

		return tobaccoData;
	}
}
