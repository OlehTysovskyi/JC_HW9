package Second_Task;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter value a: ");
		double a = scn.nextDouble();
		System.out.print("Enter value b: ");
		double b = scn.nextDouble();
	
		try {
			if(a<0 && b<0) {
				throw new IllegalArgumentException(); 
			}
			else if((a==0 && b!=0) || (a!=0 && b==0)) {
				throw new ArithmeticException();
			}
			else if(a==0 && b==0) {
				throw new IllegalArgumentException(); 
			}
			else if(a>0 && b>0) {
				throw new MyException();
			}
			Methods.dod(a, b);
			Methods.vid(a, b);
			Methods.mnz(a, b);
			Methods.dil(a, b);

		}
		catch (IllegalArgumentException e) {
			System.err.println("-You entered invaild values");
		
		}
		catch (ArithmeticException e) {
			System.err.println("-A or B cannot be: '0'");
		}
		catch (MyException e) {
			System.out.println(e.toString());
			System.err.println("You entered positive values");
		}	
		
		
	}	
}