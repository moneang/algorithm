package test;

import java.util.Scanner;

//문제: https://www.acmicpc.net/problem/9461
public class 파도반수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		for (int i = 6; i <= 100; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			System.out.println(arr[m]);
		}
	}
}
