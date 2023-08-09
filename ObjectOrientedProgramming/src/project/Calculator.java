package project;

import java.util.*;
public class Calculator {
	int n;
	int num;
	public void add(int no, int mo) {
		this.n=no;
		this.num=mo;
		int res=no+mo;
		System.out.println(res);
	}
	public void sub(int number,int num) {
		this.n=number;
		this.num=num;
		int res=number-num;
		System.out.println(res);
	}
	public void div (int num,int n) {
		this.n=num;
		this.num=n;
		int r=num/n;
		System.out.println(r);
		
	}
	public void multiply(int no,int n) {
		this.n=no;
		this.num=n;
		int r=no*n;
		System.out.println(r);
		
		
	}
	public static void main(String[] args) {
		Calculator cl=new Calculator();
		Scanner in=new Scanner(System.in);
		System.out.println("calculator");
		System.out.println("1.Add");
		System.out.println("2.Sub");
		System.out.println("3.Multiply");
		System.out.println("4.Div");
		String cc=in.nextLine();
		if(cc.equals("Add")) {
			int n=in.nextInt();
			int nh=in.nextInt();
			cl.add(n, nh);
		}
		if(cc.equals("Sub")) {
			int n=in.nextInt();
			int nm=in.nextInt();
			cl.sub(n,nm);
		}
		  if(cc.equals("Multiply")) {
			  int n=in.nextInt();
			  int nm=in.nextInt();
			  cl.multiply(n, nm);
		  }
		  if(cc.equals("Div")) {
			  int n=in.nextInt();
			  int nm=in.nextInt();
			  cl.div(n, nm);
		  }
		  
	}
	
}
