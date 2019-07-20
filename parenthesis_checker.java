import java.util.*;
import java.lang.*;

class wipro
{
	boolean opening(char ch)
	{
		if(ch=='(' || ch=='{' || ch=='[')
			return true;
		else
			return false;
	}
	boolean closing(char ch)
	{
		if(ch==')' || ch=='}' || ch==']')
			return true;
		else
			return false;
	}
	char reverseOf(char ch)
	{
		switch(ch)
		{
			case '(':
				return ')';
			case ')':
				return '(';
			case '{':
				return '}';
			case '}':
				return '{';
			case '[':
				return ']';
			case ']':
				return '[';
			default:
				return '#';
		}
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter any string: ");
		String str=in.nextLine();
		char[] stack=new char[str.length()];
		int tos=-1;
		wipro x=new wipro();
		for(int i=0;i<=str.length()-1;i++)
		{
			if(x.opening(str.charAt(i))==true)
			{
				tos++;
				stack[tos]=str.charAt(i);
			}
			else if(x.closing(str.charAt(i))==true)
			{
				if(tos==-1)
				{
					System.out.println("Invalid expression");
					System.exit(0);
				}
				if(stack[tos]!=x.reverseOf(str.charAt(i)))
				{
					System.out.println("Invalid expression");
					System.exit(0);
				}
				tos--;
			}
		}
		if(tos==-1)
			System.out.println("Valid expression");
		else
			System.out.println("Invalid expression");
	}
}