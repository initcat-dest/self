package com.base.self.switchTest;

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		switch (Integer.valueOf(scanner.nextLine())) {
		case 1:
			System.out.println(1);
			return;
		case 2:
		case 3:
			System.out.println(8);
			return;

		default:
			break;
		}
	}

}
