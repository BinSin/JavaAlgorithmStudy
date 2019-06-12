package Java.Exception.JavaExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		try {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			System.out.println(e);
		} catch (InputMismatchException e) {
			System.out.println(e.getClass().getName());
		}
	}
}
