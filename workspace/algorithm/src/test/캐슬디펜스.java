package test;
//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 캐슬디펜스{
	static class node2 implements Comparable<node2> {
		int x;
		int y;
		int d;

		node2(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(node2 o) {
			// TODO Auto-generated method stub
			if (Integer.compare(this.d, o.d) == 0)
				return Integer.compare(this.y, o.y);
			return Integer.compare(this.d, o.d);
		}
	}

	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;
	static int m;
	static int k;
	static int[][] arr;
	static int[] ch;
	static ArrayList<node> li;
	static ArrayList<node2> li2;

	static void dfs2(int[][] arr2) {
		while (true) {

			int nu = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr2[i][j] == 0)
						nu++;
				}
			}
			if (nu == n * m)
				break;
			for (int i2 = 0; i2 < li.size(); i2++) {
				li2 = new ArrayList<node2>();
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (arr2[i][j] != 0) {
							int im = Math.abs(i - li.get(i2).x) + Math.abs(j - li.get(i2).y);
							if (im <= k) {
								li2.add(new node2(i, j, im));
								Collections.sort(li2);
							}
						}
					}
				}
				if (li2.size() != 0) {
					if (arr2[li2.get(0).x][li2.get(0).y] != 3) {
						arr2[li2.get(0).x][li2.get(0).y] = 3;
						num++;
					}
				}

			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr2[i][j] == 3)
						arr2[i][j] = 0;
				}
			}
			move(arr2);
		}
		if (ma < num)
			ma = num;

	}

	static void move(int[][] arr2) {
		for (int j = 0; j < m; j++) {
			for (int i = n - 1; i >= 1; i--) {
				arr2[i][j] = arr2[i - 1][j];
			}
			arr2[0][j] = 0;
		}

	}

	static void copy(int[][] a, int[][] b) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

	static int num = 0;
	static int ma = 0;

	static void dfs(int a, int b) {
		if (b == m) {
			if (a == 3) {
				num = 0;
				int[][] arr2 = new int[n + 1][m];
				li = new ArrayList<>();
				copy(arr2, arr);
				for (int i = 0; i < m; i++) {
					if (ch[i] == 1) {
						arr2[n][i] = 2;
						li.add(new node(n, i));
					}
				}
				dfs2(arr2);
			}
			return;

		}
		ch[b] = 1;
		dfs(a + 1, b + 1);
		ch[b] = 0;
		dfs(a, b + 1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		ch = new int[m];
		arr = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0);
		System.out.println(ma);
	}
}
