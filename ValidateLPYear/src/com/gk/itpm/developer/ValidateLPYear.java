package com.gk.itpm.developer;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ValidateLPYear {

	public static void main(String[] args) {
		String greeting = "***************Leap Year?????????******************\r\n" +
				" 「うるう年」判定プログラムだよ！\r\n" +
				" 入力した年が、うるう年かそうでないか判定するよ！\r\n" +
				" \r\n" +
				" こんなの誰も買わないけど、練習だからいいんだよ！\r\n" +
				" ****************************************************";

		System.out.println(greeting);

		//必要なデータを用意
		int february = 2;
		int twoNine = 29;
		boolean isNumber = true;
		boolean isLeapYear = true;

		Scanner sc = new Scanner(System.in);

		do {
			try {
				int year = Integer.parseInt(sc.nextLine());
				LocalDate lclDt = LocalDate.of(year, february, twoNine);
				isLeapYear = true;
				//ここまでこれたら入力は正しい
				//isNumber = true;
				//ほかにもブレイクする方法
				break;
			} catch (NumberFormatException e) {
				System.out.println("年入力がおかしいよ！もう一回");
				isNumber = false;
			} catch (DateTimeException e) {
				//日付として成り立たないならうるう年ではない
				isLeapYear = false;
				//数値入力なら数値
				isNumber = true;
			}
		} while (!isNumber);

		if (isLeapYear) {
			System.out.println("入力した年は閏年だよ！");
		} else {
			System.out.println("入力した年は閏年じゃないよ！");
		}
	}
}
