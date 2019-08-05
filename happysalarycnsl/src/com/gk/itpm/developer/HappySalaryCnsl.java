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

		String engineerRank;
		int cost;

		System.out.println(greeting);

		//エンジニアランクと単金を受け付ける
		engineerRank = inputEngineerRank();
		cost =inputCost();

		double salary = CalcLogic.calcuSalary(engineerRank, cost);

		//結果出力
		showResult(salary);

	}

	//エンジニアランク入力機能
	static String inputEngineerRank() {

		Scanner sc = new Scanner(System.in);
		String engineerRank;

		do {
			System.out.println("あなたのエンジニアランクは？");
			engineerRank = sc.nextLine();

			if(!CalcLogic.validateEngingeerRank(engineerRank)) {
				System.out.println("エンジニアランクの入力不正だよ？");
			}
		} while (!CalcLogic.validateEngingeerRank(engineerRank));

//		エラーになるが面白い動きをする
//		再帰的な呼び出しをしようとするが、鏡の世界みたいに結局最初の入力に戻ってしまう。
//		if(!CalcLogic.validateEngingeerRank(engineerRank)) {
//			System.out.println("入力されたエンジニアランク不正じゃない？");
//			inputEngineerRank();
//		}

		return engineerRank;
	}

	//単金入力機能
	static int inputCost() {

		Scanner sc2 = new Scanner(System.in);
		String _cost;

		do {
			System.out.println("あなたの単金は？");
			_cost = sc2.nextLine();

			if(!CalcLogic.validateCost(_cost)) {
				System.out.println("単金の入力不正だよ？");
			}
		} while (!CalcLogic.validateCost(_cost));

//		エラーになるが面白い動きをする
//		if(!CalcLogic.validateCost(_cost)) {
//			System.out.println("入力された単金不正じゃない？");
//			inputCost();
//		}

		int cost = Integer.parseInt(_cost);

		return cost;
	}

	//結果を出力する機能
	static void showResult(double salary) {
		String resultMsg =
				"あなたの月収は・・・・\r\n" +
				"%.1f 万円\r\n" +
				"となります！！";

		System.out.println(String.format(resultMsg, salary));
	}

}
