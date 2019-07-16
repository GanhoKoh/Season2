package com.gk.itpm.developers;

public class ExNumFmtExcn {

	public static void main(String[] args) {

		String _birthYear = "1984";
		String _presentYear = "二千十九";

		int birthYear = Integer.parseInt(_presentYear);
		int presentYear = Integer.parseInt(_birthYear);

		System.out.println(birthYear);
		System.out.println(presentYear);
	}

}
