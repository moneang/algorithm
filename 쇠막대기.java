package test;
//문제: https://www.acmicpc.net/problem/10799
import java.util.Scanner;

public class 쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr;
		int nu1 = 0;
		int nu2 = 0;
		String src=sc.nextLine();
		arr=new char[src.length()];
		for(int i=0;i<src.length();i++) {
			arr[i]=src.charAt(i);
		}
		int nu=0;
		int res=0;
		for(int i=0;i<src.length()-1;i++) {
			if (arr[i]=='(' &&arr[i+1]=='(')
				nu++;
			else if(arr[i]=='(' && arr[i+1]==')')
				res+=nu;
			else if( arr[i]==')' && arr[i+1]==')') {
				res+=1;
				nu--;
			}
		}
		
		System.out.println(res);
		
		
		
	}
}
