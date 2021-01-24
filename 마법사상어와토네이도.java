package test;

import java.util.Scanner;
// 문제: https://www.acmicpc.net/problem/20057
public class 마법사상어와토네이도 {
	static int n;
	static int[][] arr;
	static int stx;
	static int sty;
	static int res = 0;

	static void ch1(int a, int b, int c, double d, int che) {// 오른,왼쪽용
		if (che == 0) {
			if (b >= 0 && a - c >= 0)
				arr[a - c][b] += (int) d;
			else
				res += (int) d;
			fornum2 += (int) d;
			if (b >= 0 && a + c < n)
				arr[a + c][b] += (int) d;
			else
				res += (int) d;
			fornum2 += (int) d;
		} else {
			if (b < n && a - c >= 0)
				arr[a - c][b] += (int) d;
			else
				res += (int) d;
			fornum2 += (int) d;
			if (b < n && a + c < n)
				arr[a + c][b] += (int) d;
			else
				res += (int) d;
			fornum2 += (int) d;
		}
	}

	static void ch2(int a, int b, int c, double d, int che) {// 위,아래용
		if (che == 0) {
			if ((a < n) && b - c >= 0)
				arr[a][b - c] += (int) d;
			else
				res += (int) d;
			fornum2 += (int) d;
			if (a < n && b + c < n)
				arr[a][b + c] += (int) d;
			else
				res += (int) d;
			fornum2 += (int) d;
		} else {
			if ((a >= 0) && b - c >= 0)
				arr[a][b - c] += (int) d;
			else
				res += (int) d;
			fornum2 += (int) d;
			if (a >= 0 && b + c < n)
				arr[a][b + c] += (int) d;
			else
				res += (int) d;
			fornum2 += (int) d;
		}
	}

	static int fornum2 = 0;

	static void right(int x, int y) {
		fornum2 = 0;
		int a = x;
		int b = y;
		int num1 = arr[a][b + 1];
		double num = num1 / (double) 100;
		ch1(a, b, 1, num, 1);
		ch1(a, b + 1, 1, num * 7, 1);
		ch1(a, b + 1, 2, num * 2, 1);
		ch1(a, b + 2, 1, num * 10, 1);

		if (b + 3 < n)
			arr[a][b + 3] += (int) (num * 5);
		else
			res += (int) (num * 5);
		fornum2 += (int) (num * 5);
		int num2 = num1 - fornum2;
		if (b + 2 < n)
			arr[a][b + 2] += num2;
		else
			res += num2;
		arr[a][b + 1] = 0;
	}

	static void left(int x, int y) {
		fornum2 = 0;
		int a = x;
		int b = y;
		int num1 = arr[a][b - 1];
		double num = num1 / (double) 100;

		ch1(a, b, 1, num, 0);
		ch1(a, b - 1, 1, num * 7, 0);
		ch1(a, b - 1, 2, num * 2, 0);
		ch1(a, b - 2, 1, num * 10, 0);
		if (b - 3 >= 0) {
			arr[a][b - 3] += (int) (num * 5);
		} else
			res += (int) (num * 5);
		fornum2 += (int) (num * 5);

		int num2 = num1 - fornum2;
		if (b - 2 >= 0)
			arr[a][b - 2] += (int) num2;
		else
			res += (int) num2;
		arr[a][b - 1] = 0;
	}

	static void up(int x, int y) {
		fornum2 = 0;
		int a = x;
		int b = y;
		int num1 = arr[a - 1][b];
		double num = num1 / (double) 100;
		ch2(a, b, 1, num, 1);
		ch2(a - 1, b, 1, num * 7, 1);
		ch2(a - 1, b, 2, num * 2, 1);
		ch2(a - 2, b, 1, num * 10, 1);
		if (a - 3 >= 0)
			arr[a - 3][b] += (int) (num * 5);
		else
			res += (int) (num * 5);

		fornum2 += (int) (num * 5);
		int num2 = num1 - fornum2;
		if (a - 2 >= 0)
			arr[a - 2][b] += (int) num2;
		else
			res += (int) num2;
		arr[a - 1][b] = 0;
	}

	static void down(int x, int y) {
		fornum2 = 0;
		int a = x;
		int b = y;
		int num1 = arr[a + 1][b];
		double num = num1 / (double) 100;

		ch2(a, b, 1, num, 0);
		ch2(a + 1, b, 1, num * 7, 0);
		ch2(a + 1, b, 2, num * 2, 0);
		ch2(a + 2, b, 1, num * 10, 0);
		if (a + 3 < n)
			arr[a + 3][b] += (int) (num * 5);
		else
			res += (int) (num * 5);
		fornum2 += (int) (num * 5);
		int num2 = num1 - fornum2;
		if (a + 2 < n)
			arr[a + 2][b] += (int) num2;
		else
			res += (int) num2;
		arr[a + 1][b] = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		stx = n / 2;
		sty = n / 2;
		int lonum = 1;
		for (int i = 0; i <= n / 2; i++) {
			if (i == (n / 2))
				lonum -= 1;
			boolean chee = false;
			for (int intleft = 0; intleft < lonum; intleft++) {
				left(stx, sty);
				sty -= 1;
				if (stx == 0 && sty == 0) {
					chee = true;
					break;
				}
			}

			if (chee == true)
				break;
			for (int intdown = 0; intdown < lonum; intdown++) {
				down(stx, sty);
				stx += 1;
			}

			for (int intright = 0; intright < lonum + 1; intright++) {
				right(stx, sty);
				sty += 1;
			}

			for (int intup = 0; intup < lonum + 1; intup++) {
				up(stx, sty);
				stx -= 1;
			}
			lonum += 2;
		}
		System.out.println(res);

	}
}
