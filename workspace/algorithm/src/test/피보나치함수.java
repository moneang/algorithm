package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {
	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(br.readLine());
			for(int j=0;j<tc;j++) {
				int num=Integer.parseInt(br.readLine());
				int[] arr1=new int[41];
				int[] arr2=new int[41];
				arr1[0]=1;
				arr2[0]=0;
				arr1[1]=0;
				arr2[1]=1;
				for(int i=2;i<=40;i++) {
					arr1[i]=arr1[i-1]+arr1[i-2];
					arr2[i]=arr2[i-1]+arr2[i-2];	
				}
				System.out.println(arr1[num]+" "+arr2[num]);
				
			}
		}
}
