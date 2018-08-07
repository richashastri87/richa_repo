package New;

public class reverse 
{
	public String reverse(String str) 
	{     
		if ((str==null)||(str.length() <= 1))
			return str;
	    return reverse(str.substring(1)) + str.charAt(0);
	}
	
	public static void main(String[] args) 
	{
		reverse obj=new reverse();
	    String str = "Quora";
	    System.out.println("Reverse of \'"+str+"\' is \'"+obj.reverse(str)+"\'");    
	}    
}
