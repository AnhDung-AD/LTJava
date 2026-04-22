package cummunityuni;

import java.util.Scanner;

public class Baitap2 {

	public static boolean Panlyndrome(String s) {
		int n = s.length();
		for (int i = 0; i < n / 2; i++) {
			if (s.charAt(i) != s.charAt(n - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhập vào một chuỗi để kiểm tra: ");
		String input = sc.nextLine();
		
		if (Panlyndrome(input)) {
			System.out.println("=> '" + input + "' ĐÚNG là chuỗi Panlyndrome!");
		} else {
			System.out.println("=> '" + input + "' KHÔNG PHẢI là chuỗi Panlyndrome.");
		}
		
		sc.close();
	}

}