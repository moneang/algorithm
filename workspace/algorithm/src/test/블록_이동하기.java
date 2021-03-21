package test;

import java.util.LinkedList;
import java.util.Queue;

public class 블록_이동하기 {
	class node {
		int x1;
		int y1;
		int x2;
		int y2;
		int t;
		int d;

		node(int x1, int y1, int x2, int y2, int t, int d) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.t = t;
			this.d = d;
		}
	}

	public int n;
	public int[][][] ch;
	public int[][] arr;

	public boolean check(int x, int y, int d) {

		if (x >= 0 && y >= 0 && x < n && y < n && ch[x][y][d] == 0) {
			return true;
		} else
			return false;
	}

	public boolean check2(int x1, int y1, int x2, int y2) {

		if (x1 >= 0 && y1 >= 0 && x1 < n && y1 < n && x2 < n && x2 >= 0 && y2 >= 0 && x2 < n && y2 < n
				&& arr[x1][y1] == 0 && arr[x2][y2] == 0)
			return true;
		else
			return false;
	}

	public int re = 0;
	public int[] dx1 = { -1, 1, 0, 0 };
	public int[] dy1 = { 0, 0, -1, 1 };

	public int solution(int[][] board) {
		int answer = 0;
		re = 0;
		ch = new int[board.length][board.length][2];
		n = board.length;
		arr = new int[board.length][board.length];
		for (int i = 0; i < n; i++)
			arr[i] = board[i].clone();
		bfs();
		answer = re;
		return answer;
	}

	public void bfs() {
		Queue<node> q = new LinkedList<node>();
		q.add(new node(0, 0, 0, 1, 0, 0));
		ch[0][1][0] = 1;
		ch[0][0][0] = 1;
		while (!q.isEmpty()) {
			node tm = q.poll();
			if ((tm.x1 == n - 1 && tm.y1 == n - 1) || (tm.x2 == n - 1 && tm.y2 == n - 1)) {
				re = tm.t;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx1 = tm.x1 + dx1[i];
				int ny1 = tm.y1 + dy1[i];
				int nx2 = tm.x2 + dx1[i];
				int ny2 = tm.y2 + dy1[i];
				if ((check(nx1, ny1, tm.d) || check(nx2, ny2, tm.d)) && (check2(nx1, ny1, nx2, ny2))) {
					if (check(nx1, ny1, tm.d)) {
						ch[nx1][ny1][tm.d] = 1;
					}
					if (check(nx2, ny2, tm.d))
						ch[nx2][ny2][tm.d] = 1;
					q.add(new node(nx1, ny1, nx2, ny2, tm.t + 1, tm.d));
				}
			}
			if (tm.d == 0) {
				for (int i = 0; i < 2; i++) {
					int nx1 = tm.x2 + dx1[i];
					int ny1 = tm.y2 + dy1[i];
					int nx2 = tm.x1 + dx1[i];
					int ny2 = tm.y1 + dy1[i];
					if (((check(nx2, ny2, 1) || check(tm.x1, tm.y1, 1))) && (check2(nx1, ny1, nx2, ny2))) {
						if (check(tm.x1, tm.y1, tm.d))
							ch[tm.x1][tm.y1][1] = 1;
						if (check(nx2, ny2, tm.d))
							ch[nx2][ny2][1] = 1;
						q.add(new node(tm.x1, tm.y1, nx2, ny2, tm.t + 1, 1));
					}
					if (((check(nx2, ny2, 1) || check(tm.x2, tm.y2, 1))) && (check2(nx1, ny1, nx2, ny2))) {
						if (check(tm.x2, tm.y2, tm.d))
							ch[tm.x2][tm.y2][1] = 1;
						if (check(nx1, ny1, tm.d))
							ch[nx1][ny1][1] = 1;
						q.add(new node(tm.x2, tm.y2, nx1, ny1, tm.t + 1, 1));
					}
				}
			} else {
				for (int i = 2; i < 4; i++) {
					int nx1 = tm.x2 + dx1[i];
					int ny1 = tm.y2 + dy1[i];
					int nx2 = tm.x1 + dx1[i];
					int ny2 = tm.y1 + dy1[i];
					if (((check(nx2, ny2, 0) || check(tm.x1, tm.y1, 0))) && (check2(nx1, ny1, nx2, ny2))) {
						if (check(tm.x1, tm.y1, 0))
							ch[tm.x1][tm.y1][0] = 1;
						if (check(nx2, ny2, 0))
							ch[nx2][ny2][0] = 1;
						q.add(new node(tm.x1, tm.y1, nx2, ny2, tm.t + 1, 0));
					}
					if (((check(nx2, ny2, 0) || check(tm.x2, tm.y2, 0))) && (check2(nx1, ny1, nx2, ny2))) {
						if (check(tm.x2, tm.y2, 0))
							ch[tm.x2][tm.y2][0] = 1;
						if (check(nx1, ny1, 0))
							ch[nx1][ny1][0] = 1;
						q.add(new node(tm.x2, tm.y2, nx1, ny1, tm.t + 1, 0));
					}
				}
			}
		}
	}

}