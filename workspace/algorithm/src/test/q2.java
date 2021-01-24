package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q2 {
	static ArrayList<Integer> li;
	static ArrayList<Integer> li2;
	static int n;
	static int[] arr;
	static int[] ch;

	static int ch() {
		int[] ar2 = new int[n + 1];
		int[] ar3 = new int[n + 1];
		li = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (ch[i] == 1) {
				li.add(i);
				ar2[i] = 1;
				ar3[arr[i]] = 1;
			}
		}
		num = 0;
		for (int i = 1; i <= n; i++) {
			if (ar2[i] == 1 && ar3[i] == 1) {
				num++;
			}
		}
		if (num == li.size())
			return 1;
		else
			return 0;

	}

	static int num = 0;
	static int ma = 0;

	static void dfs(int nu) {

		if (nu == n + 1) {
			
			int nu2 = 0;
			for (int i = 1; i <= n; i++) {
				if (ch[i] == 1)
					nu2++;
			}
			if (ma >= nu2)
				return;
			System.out.println(ma);
			System.out.println(Arrays.toString(ch));
			if (ch() == 1) {
				if (num > ma) {
					ma = num;
					li2 = new ArrayList<>();
					for (int i = 0; i < li.size(); i++)
						li2.add(li.get(i));
				}
//			System.out.println(ma);
			}
			return;
		}
		ch[nu] = 1;
		dfs(nu + 1);
		ch[nu] = 0;
		dfs(nu + 1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n + 1];
		ch = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dfs(1);
		System.out.println(ma);
		for (int i = 0; i < li2.size(); i++)
			System.out.println(li2.get(i));
	}
}
