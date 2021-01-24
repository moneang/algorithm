package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1 {
	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Integer> li;
	static Queue<node> q;
	static int n;
	static int m;
	static int[][] ch;
	static char[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int im = 1;
	static int im2 = 0;

	static void bfs() {
		while (!q.isEmpty()) {
			node tm = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tm.x + dx[i];
				int ny = tm.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0 && arr[nx][ny] == '1') {
					ch[nx][ny] = 1;
					q.add(new node(nx, ny));
					im++;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new char[n][n];
		ch = new int[n][n];
		for (int i = 0; i < n; i++) {
			String src = sc.next();
			for (int j = 0; j < n; j++) {
				arr[i][j] = src.charAt(j);
			}
		}
		li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (ch[i][j] == 0 && arr[i][j] == '1') {
					im2++;
					q = new LinkedList<>();
					q.add(new node(i, j));
					ch[i][j] = 1;
					bfs();
					li.add(im);
					Collections.sort(li);
					im = 1;
				}
			}
		}

		System.out.println(im2);
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
	}
}
