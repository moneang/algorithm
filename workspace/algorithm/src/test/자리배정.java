package test;

//문제: https://www.acmicpc.net/problem/10157
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 자리배정 {
	static class node {
		int num;
		int di;
		int x;
		int y;

		node(int num, int di, int x, int y) {
			this.num = num;
			this.di = di;
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<node> li;
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int nn = sc.nextInt();
		if (nn > n * m)
			System.out.println(0);
		else {
			int num = 1;
			li = new ArrayList<>();
			// 1:위/2:오른쪽/3:아래:4:왼쪽
			boolean che = false;
			li.add(new node(0, 0, 0, 0));
			li.add(new node(num, 1, 1, 1));
			num += (n - 1);
			li.add(new node(num, 2, 1, n));
			num += (m - 1);
			li.add(new node(num, 3, m, n));
			num += (n - 1);
			li.add(new node(num, 4, m, 1));
			int nu2 = 1;
			int xx = m;
			int yy = 1;
			int ti = 2;
			int nuu = 1;
			for (int i = 0; i < 4 * (n / 2) - 3; i++) {
				if (che == false) {
					num += (m - ti);
					che = true;
					if (nu2 == 1)// 저장할값이 1임
					{
						xx -= (m - ti); // xx=2,3
						li.add(new node(num, nu2, xx, yy));

					} else // 오른 왼
					{
						li.add(new node(num, nu2, (xx + (m - ti)), yy));
						xx += (m - ti);// xx=6
					}
				} else {
					num += (n - ti);
					che = false;

					if (nu2 == 2) {
						li.add(new node(num, nu2, xx, (yy + (n - ti))));
						yy = yy + (n - ti);

					} else {
						li.add(new node(num, nu2, xx, (yy - (n - ti))));
						yy = (yy - (n - ti));
					}
					ti++;
				}
				nu2++;
				if (nu2 > 4) {
					nu2 = 1;
				}

			}
			int res = 0;
			int resdi = 0;
			int resx = 0;
			int resy = 0;
			boolean check = false;
			for (int i = 1; i < li.size(); i++) {
				if (nn == li.get(i).num) {
					resx = li.get(i).x;
					resy = li.get(i).y;
					check = true;
					break;
				}

			}
			if (check == true) {
				System.out.println(resx + " " + resy);
			}

			if (check == false) {
				for (int i = 2; i < li.size(); i++) {

					if (nn < li.get(i).num) {
						res = li.get(i - 1).num;
						resdi = li.get(i - 1).di;
						resx = li.get(i - 1).x;
						resy = li.get(i - 1).y;
						break;
					}
				}
				int resnum = nn - res;

				if (resdi == 1) {
					resy += resnum;
				} else if (resdi == 2) {
					resx += resnum;
				} else if (resdi == 3) {
					resy -= resnum;
				} else {
					resx -= resnum;
				}
				System.out.println(resx + " " + resy);
			}
		}
	}
}
