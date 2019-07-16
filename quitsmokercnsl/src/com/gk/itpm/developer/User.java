package com.gk.itpm.developer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

	//日付情報
	private LocalDate fromLd;
	private LocalDateTime fromLdt;
	private LocalDate toLd;
	private LocalDateTime toLdt;

	//タバコ情報
	int tobaccoPrice;
	int tobaccoNum;
	int tobaccoPerDayNum;

	public LocalDate getFromLd() {
		return fromLd;
	}

	public void setFromLd(LocalDate fromLd) {
		this.fromLd = fromLd;
	}

	public LocalDateTime getFromLdt() {
		return fromLdt;
	}

	public void setFromLdt(LocalDateTime fromLdt) {
		this.fromLdt = fromLdt;
	}

	public LocalDate getToLd() {
		return toLd;
	}

	public void setToLd(LocalDate toLd) {
		this.toLd = toLd;
	}

	public LocalDateTime getToLdt() {
		return toLdt;
	}

	public void setToLdt(LocalDateTime toLdt) {
		this.toLdt = toLdt;
	}

	public int getTobaccoPrice() {
		return tobaccoPrice;
	}

	public void setTobaccoPrice(int tobaccoPrice) {
		this.tobaccoPrice = tobaccoPrice;
	}

	public int getTobaccoNum() {
		return tobaccoNum;
	}

	public void setTobaccoNum(int tobaccoNum) {
		this.tobaccoNum = tobaccoNum;
	}

	public int getTobaccoPerDayNum() {
		return tobaccoPerDayNum;
	}

	public void setTobaccoPerDayNum(int tobaccoPerDayNum) {
		this.tobaccoPerDayNum = tobaccoPerDayNum;
	}

	//コンストラクタ
	User(LocalDateTime fromLdt) {
		this.fromLdt = fromLdt;
		this.fromLd = fromLdt.toLocalDate();

		//現在時刻で強制的に現在日付を作成
		//先にLocalDateTimeを作成して、そのデータからLocalDateを作成※時間ズレをなくすため
		this.toLdt = LocalDateTime.now();
		this.toLd = toLdt.toLocalDate();
	}

}
