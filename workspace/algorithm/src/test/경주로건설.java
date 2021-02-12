package test;

public class 경주로건설 {
	static int mi = 98765432;
	static int[] dx = { 0, 1, 0, -1 };// 동남서북
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] ch;

	static void dfs(int x, int y, int[][] ar, int nu, int di) {

		if (cc[x][y] < nu)
			return;
		cc[x][y] = nu;
		if (mi < nu)
			return;

		if (x == ar.length - 1 && y == ar.length - 1) {
			if (mi > nu) {
				mi = nu;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < ar.length && ny < ar.length && ch[nx][ny] == 0 && ar[nx][ny] == 0) {
				if (i == di) {
					ch[nx][ny] = 1;
					int im = nu + 100;
					dfs(nx, ny, ar, im, i);
					ch[nx][ny] = 0;
				} else {
					ch[nx][ny] = 1;
					int im = nu + 600;
					dfs(nx, ny, ar, im, i);
					ch[nx][ny] = 0;
				}

			}
		}
	}
	static int[][] cc;

	public int solution(int[][] board) {
		int answer = 0;
		ch = new int[board.length][board.length];
		cc = new int[board.length][board.length];
		int[][][] res = new int[board.length][board.length][2];
		ch[0][0] = 1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				cc[i][j] = 98765432;
			}
		}
		dfs(0, 0, board, 0, 0);
		dfs(0, 0, board, 0, 1);

		answer = mi;
		return answer;
	}
}
