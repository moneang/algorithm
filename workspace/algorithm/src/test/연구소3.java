package test;
//문제: https://www.acmicpc.net/problem/17142
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소3 {
	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class node2 {
		int x;
		int y;
		int t;

		node2(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static ArrayList<node> li;
	static Queue<node2> q;
	static int n;
	static int m;
	static boolean che=false;
	static int[][] arr;
	static int[][] ch;
	static int[][] ch2;
	static int[][] arr2;// 시간체크
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int mi=98765432;
	static void dfs2(int num) {
		while (!q.isEmpty()) {
			node2 tm = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tm.x + dx[i];
				int ny = tm.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] != -2 && ch2[nx][ny] == 0
						&& arr2[nx][ny] == 0) {
					ch2[nx][ny] = 1;
					num++;
					arr2[nx][ny] = tm.t + 1;
					q.add(new node2(nx, ny, tm.t + 1));
				}
			}
		}
		if(num==nuu)
		{
			che=true;
			int ma=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(arr[i][j]==0 && ch2[i][j]==1)
					{
						if(arr2[i][j]>ma)
						ma=arr2[i][j];
					}
				}
			}
			
			if(mi>ma)
				mi=ma;
		}
	}
	static int nuu = 0;

	static void dfs(int nu, int nu2) {
		if (nu == li.size()) {
			if (nu2 == m) {
				q = new LinkedList<>();
				arr2 = new int[n][n];
				ch2 = new int[n][n];
				int nuuu=0;
				for (int i = 0; i < li.size(); i++) {
					if (ch[li.get(i).x][li.get(i).y] == 1) {
						q.add(new node2(li.get(i).x, li.get(i).y, 0));
						ch2[li.get(i).x][li.get(i).y] = 1;
						nuuu++;
					}
				}
				dfs2(nuuu);
				
			}
			return;
		}

		ch[li.get(nu).x][li.get(nu).y] = 1;
		dfs(nu + 1, nu2 + 1);
		ch[li.get(nu).x][li.get(nu).y] = 0;
		dfs(nu + 1, nu2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][n];
		ch = new int[n][n];
		li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]!=1)
					nuu++;
				if (arr[i][j] == 2)
					li.add(new node(i, j));
				if (arr[i][j] == 1)
					arr[i][j] = -2;
			}
		}
		if (li.size() == 0) {
			System.out.println(-1);
		} else {
			dfs(0, 0);
			if(che==false)
				System.out.println(-1);
			else
			System.out.println(mi);
		}

	}
}
