package com.gk.itpm.developer;

public class User {

	private String engineerRank;
	private int cost;
	private int salary;

	public String getEngineerRank() {
		return engineerRank;
	}
	public void setEngineerRank(String engineerRank) {
		this.engineerRank = engineerRank;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getSalay() {
		return salary;
	}
	public void setSalay(int salary) {
		this.salary = salary;
	}

	/**
	 * コンストラクタ
	 */
	public User(String engineerRank, int cost, int salary) {
		this.engineerRank = engineerRank;
		this.cost = cost;
		this.salary = salary;
	}

}
