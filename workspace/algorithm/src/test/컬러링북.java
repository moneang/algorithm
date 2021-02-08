package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 컬러링북 {
	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<node> q;
	static int[][] ch;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int ma = 0;

	static void bfs(int m3, int n3, int nu, int[][] ar) {
		int nu2 = 1;
		while (!q.isEmpty()) {
			node tm = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tm.x + dx[i];
				int ny = tm.y + dy[i];
				if(nx>=0&&ny>=0&&nx<m3&&ny<n3)
				if (nx >= 0 && ny >= 0 && nx < m3 && ny < n3 && ch[nx][ny] == 0 && ar[nx][ny] == nu) {
					ch[nx][ny] = nu;
					q.add(new node(nx, ny));
					nu2++;
				}
			}
		}
		if (ma < nu2)
			ma = nu2;

	}

	static ArrayList<Integer> li;

	static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		li = new ArrayList<>();

		int[] answer = new int[2];
        ma=0;
		ch = new int[m][n];
		q = new LinkedList<>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (ch[i][j] == 0 && picture[i][j] != 0) {
					numberOfArea++;
					maxSizeOfOneArea++;
					ch[i][j] = picture[i][j];
					q.add(new node(i, j));
					bfs(m, n, picture[i][j], picture);

				}
			}
		}

		maxSizeOfOneArea=ma;
		answer[0] =numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}
