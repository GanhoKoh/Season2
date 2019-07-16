package com.gk.itpm.developer;

import java.util.Scanner;

public class ValidateLPYear {

	public static void main(String[] args) {
		String greeting =
				"***************Leap Year?????????******************\r\n" +
				" 「うるう年」判定プログラムだよ！\r\n" +
				" 入力した年が、うるう年かそうでないか判定するよ！\r\n" +
				" \r\n" +
				" こんなの誰も買わないけど、練習だからいいんだよ！\r\n" +
				" ****************************************************";

		System.out.println(greeting);

		int inputYear =
	}

	static int inputYear() {
		System.out.println("判定したい年は？？:yyyy");
		Scanner sc = new Scanner(System.in);
		String _inputYear = sc.nextLine();
		
	}

	static boolean validateYear(int year) {

	}

}
