package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
// 문제: https://www.acmicpc.net/problem/10800


public class 컬러볼 {
	static class node implements Comparable<node> {
		int num;
		int x;
		int y;

		node(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			if (Integer.compare(this.y, o.y) == 0)
				return Integer.compare(this.x, o.x);
			return Integer.compare(this.y, o.y);
		}
	}

	static class node2 implements Comparable<node2> {
		int num;
		int re;

		node2(int num, int re) {
			this.num = num;
			this.re = re;
		}

		@Override
		public int compareTo(node2 o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.num, o.num);
		}
	}

	static int n;
	static ArrayList<node> li;
	static ArrayList<node2> my;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		li = new ArrayList<>();
		my = new ArrayList<>();
		sb = new StringBuilder();
		int[] arr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			li.add(new node(i, n1, n2));
		}
		Collections.sort(li);
		int sum = 0;
		int before = 0;
		int beforecolor = 0;
		int beforenum = 0;
		int beforre = 0;
		int nuu = 0;// 무조건더함
		int nuu2 = 0;
		for (int i = 0; i < li.size(); i++) {
			int nu = 0;
			if (before != li.get(i).y) {// 같지않다면 여태 누적+

				nuu += li.get(i).y;
				arr[li.get(i).x] += li.get(i).y;
				nu = nuu - arr[li.get(i).x];
				nuu2 = nuu;
				beforre = nu;
			} else {

				if (beforecolor != li.get(i).x) {
					arr[li.get(i).x] += li.get(i).y;
					nu = nuu2 - arr[li.get(i).x];

				} else {
					nu = beforre;
					arr[li.get(i).x] += li.get(i).y;

				}
				beforre = nu;
				nuu += li.get(i).y;
			}

			my.add(new node2(li.get(i).num, nu));
			before = li.get(i).y;
			beforecolor = li.get(i).x;

		}
		Collections.sort(my);

		for (int i = 0; i < my.size(); i++) {
			int n2 = my.get(i).re;
			sb.append(n2 + "\n");
		}
		System.out.println(sb.toString());

	}
}
