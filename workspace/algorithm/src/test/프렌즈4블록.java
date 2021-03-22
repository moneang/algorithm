package test;

public class 프렌즈4블록 {
	static void check(int x, int y, int ch) {
		if (x + 1 >= ren || y + 1 >= rem)
			return;
		if (arr[x][y + 1] != ch || arr[x + 1][y] != ch || arr[x + 1][y + 1] != ch)
			return;
		chh = true;
		for (int i = x; i < x + 2; i++) {
			for (int j = y; j < y + 2; j++) {
				ch2[i][j] = -2;
			}
		}
	}

	static char[][] arr;
	static int ren;
	static int rem;
	static int[][] ch2;
	static boolean chh = false;

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		arr = new char[m][n];
		ch2 = new int[m][n];
		ren = m;
		rem = n;
		for (int i = 0; i < ren; i++) {
			for (int j = 0; j < rem; j++) {
				arr[i][j] = board[i].charAt(j);
			}
		}
		int re = 0;
		while (true) {
			chh = false;
			ch2 = new int[ren][rem];
			for (int i = 0; i < ren; i++) {
				for (int j = 0; j < rem; j++) {
					if (arr[i][j] != '-') {
						if (ch2[i][j] == 0)
							ch2[i][j] = -1;
						check(i, j, arr[i][j]);
					}
				}
			}
			if (chh == false)
				break;
			for (int i = 0; i < ren; i++) {
				for (int j = 0; j < rem; j++) {
					if (ch2[i][j] == -2) {
						arr[i][j] = '-';
						re++;
					}
				}
			}

			for (int i = 0; i < rem; i++) {
				for (int j = ren - 1; j >= 1; j--) {
					for (int k = j - 1; k >= 0; k--) {
						if (arr[j][i] != '-')
							break;
						if (arr[k][i] != '-') {
							arr[j][i] = arr[k][i];
							arr[k][i] = '-';
							break;
						}
					}
				}
			}
		}
		answer = re;
		return answer;
	}
}
