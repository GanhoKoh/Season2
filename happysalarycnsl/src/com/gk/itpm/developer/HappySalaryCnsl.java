package com.gk.itpm.developer;

import java.util.Scanner;

public class HappySalaryCnsl {

	public static void main(String[] args) {
		String greeting =
				" ***************ITPM用の月収計算アプリ******************\r\n" +
				" エンジニアランクと単価を入力して<br>\r\n" +
				" 月収を計算する簡易Webアプリだよ<br>\r\n" +
				" \r\n" +
				" これで単金アップした時の事を考えてスキルアップ！<br>\r\n" +
				" ****************************************************";

		System.out.println(greeting);

		//エンジニアランクと単金を受け付ける
		String engineerRank = inputEngineerRank();
		int cost = inputCost();

		int salary = CalcLogic.calcuSalary(engineerRank, cost);

		//結果出力
		showResult(salary);


	}

	//エンジニアランク入力機能
	static String inputEngineerRank() {

		System.out.println("あなたのエンジニアランクは？");

		Scanner sc1 = new Scanner(System.in);
		String engineerRank = sc1.nextLine();

		if(!CalcLogic.validateEngingeerRank(engineerRank)) {
			System.out.println("入力されたエンジニアランク不正じゃない？");
			inputEngineerRank();
		}

		return engineerRank;
	}

	//単金入力機能
	static int inputCost() {

		System.out.println("あなたの単金は？");

		Scanner sc2 = new Scanner(System.in);
		String cost = sc2.nextLine();

		if(!CalcLogic.validateCost(cost)) {
			System.out.println("入力された単金不正じゃない？");
			inputCost();
		}

		return Integer.parseInt(cost);
	}

	//結果を出力する機能
	static void showResult(int salary) {
		String resultMsg =
				"あなたの月収は・・・・\r\n" +
				"%d 万円\r\n" +
				"となります！！";

		System.out.println(String.format(resultMsg, salary));
	}

}
