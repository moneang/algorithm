package test;

import java.util.ArrayList;

public class 크래인인형뽑기 {

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		ArrayList<Integer> li = new ArrayList<>();
		for (int i = 0; i < moves.length; i++) {
			int nu = -1;
			for (int j = 0; j < board.length; j++) {

				if (board[j][moves[i] - 1] != 0) {
					if (li.size() == 0)
						li.add(board[j][moves[i] - 1]);
					else
						nu = board[j][moves[i] - 1];
					board[j][moves[i] - 1] = 0;
					break;
				}

			}
			if (li.size() >= 1 && nu != -1) {
				int si = li.size();
				if (nu == li.get(si - 1)) {
					answer += 2;
					li.remove(si - 1);
				} else
					li.add(nu);
			}
		}
		return answer;
	}
}
