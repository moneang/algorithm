package test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayList;

class Solution {
    	static class node {
		int pro;
		int speed;
		node(int pro, int speed) {
			this.pro = pro;
			this.speed = speed;
		}
	}
	static ArrayList<Integer> li;
	static Queue<node> q;
    
    public int[] solution(int[] progresses, int[] speeds) {
        q = new LinkedList<>();
		li = new ArrayList<>();
		int[] answer = {};
		for (int i = 0; i < progresses.length; i++) {
			q.add(new node(progresses[i], speeds[i]));
		}
		while (!q.isEmpty()) {
			node tm = q.poll();
			int nu = 0;
			if (tm.pro >= 100) {
				nu++;
				int si = q.size();
				boolean che = false;
				for (int i = 0; i < si; i++) {
					node tm2 = q.poll();
					if (che == false && tm2.pro >= 100) {
						nu++;
					} else {
						che = true;
						q.add(new node(tm2.pro, tm2.speed));
					}
				}
				li.add(nu);
			} else {
				int nu3 = tm.pro;
				int nu4 = tm.speed;
				int si = q.size();
				q.add(new node( nu3 + nu4, nu4));
				for (int i = 0; i < si; i++) {
					node tm2 = q.poll();
					int num1 = tm2.pro;
					int num2 = tm2.speed;
					q.add(new node( num1 + num2, num2));
				}
			}
		}
		answer=new int[li.size()];
		for (int i = 0; i < li.size(); i++) {
			answer[i]=li.get(i);
		}
		return answer;
    }
}