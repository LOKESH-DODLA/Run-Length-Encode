//  Run Length Encode (Decodeing)
  // 2(abc)  ,2(a)3(bc) 
  
import java.util.*;
class Decode
{
	public static String RLEDecodeingString(String s)
	{
		// (abc)2  
		Stack<Integer> counts = new Stack();
		Stack<String> result = new Stack();
		String res = "" ;
		int Index = 0;
		
		// (abc)2
		
		while( Index < s.length())
		{
			if(s.charAt(Index)=='(')  // ( == (
			{
				result.push(res);
				res = "";
				Index++;
				
			}
			else if(s.charAt(Index)==')')
			{
				StringBuilder sb = new StringBuilder(result.pop());
				int count = counts.pop();
				for(int i =0 ; i<count ; i++)
				{
					sb.append(res);
				}
				res = sb.toString();
				Index++;
			}
			else if (Character.isDigit(s.charAt(Index)))
			{
				int count = 0;
				while (Character.isDigit(s.charAt(Index)))
				{
					count = 10*count + (s.charAt(Index)-'0');
					Index++;
				}
				counts.push(count);
			}
			else 
			{
				res += s.charAt(Index);
				Index++;
			}
		}
		return res;
	}
	public static void main(String[]args)
	{
		String res;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String :");
		res = RLEDecodeingString(sc.nextLine());
		System.out.println(res);
		
	}
}


