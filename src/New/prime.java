package New;

import java.util.Scanner;

public class prime {

	public static void main(String[] args)
	{
		int num;
		Scanner sc;
		System.out.println("1 : prime \n 2: Armstorm number \n 3: reverse number \n 4: String reverse \n 5: Exit");
		int oo;
		prime obj = new prime();
		sc = new Scanner(System.in);
		oo = sc.nextInt();
		switch(oo)
		{
		case 1: 
				System.out.println("Enter the number for search");
				num = sc.nextInt();
				boolean flag = false;
				for(int i = 2; i< num /2; ++i)
				{
					if(num % i == 0)
						flag = true;
						break;
				}
		
				if(flag == false)
					System.out.println("prime");
				else
					System.out.println("not prime");
		 break;
		 
		 
		case 2: 
				System.out.println("Enter the number");
				num = sc.nextInt();
				int reverse = 0;
				int div ;
				while(num > 0)
				{
					div = num % 10;
				    num = num / 10;
					reverse = reverse  + (div *div * div);
					//System.out.println(reverse);
				}
				
				System.out.println("Reverse number " +reverse);
				break;
				
		
		case 3: 
			   System.out.println("Enter the string");
			   String str = sc.next();
			   String reverseS;
			   reverseS = obj.callFunction(str);
			   System.out.println("Reverse " + reverseS);
			   
			   break;
			   
		case 4 : 
			   break;
			   
		case 5 : System.out.println("Default case");
			   break;
			   
				
		}
	}

	 public String callFunction(String str)
	 {
		if(str.length() <=1 || str==null)
			return str;
		else
			return callFunction(str.substring(1) + str.charAt(0));
		
	 }

}
