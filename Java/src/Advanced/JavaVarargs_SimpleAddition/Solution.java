package Advanced.JavaVarargs_SimpleAddition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class Add {
	void add(int ... args) {
		String str = new String();
		int sum = 0;
		
		for(int n : args) {
			str += n + "+";
			sum += n;
		}
		
		str = str.substring(0, str.length()-1);
		str += "=" + sum;
		
		System.out.println(str);
	}
}

public class Solution {

    public static void main(String[] args) {
       try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int n1=Integer.parseInt(br.readLine());
			int n2=Integer.parseInt(br.readLine());
			int n3=Integer.parseInt(br.readLine());
			int n4=Integer.parseInt(br.readLine());
			int n5=Integer.parseInt(br.readLine());
			int n6=Integer.parseInt(br.readLine());
			Add ob=new Add();
			ob.add(n1,n2);
			ob.add(n1,n2,n3);
			ob.add(n1,n2,n3,n4,n5);	
			ob.add(n1,n2,n3,n4,n5,n6);
			Method[] methods=Add.class.getDeclaredMethods();
			Set<String> set=new HashSet<>();
			boolean overload=false;
			for(int i=0;i<methods.length;i++)
			{
				if(set.contains(methods[i].getName()))
				{
					overload=true;
					break;
				}
				set.add(methods[i].getName());
				
			}
			if(overload)
			{
				throw new Exception("Overloading not allowed");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}

/*
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Add {
		
		public int add(int ... args) {
			int sum = 0;
			for(int num : args) {
				sum += num;
			}
			
			return sum;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Add ad = new Add();
		String str = new String();
		String Output = new String();
		StringTokenizer st;
		
		for(int i=0; i<6; i++) {
			str = br.readLine();
			Output += str + "+";
			if(i%3 != 0) {
				st = new StringTokenizer(Output, "+");
				int[] num = new int[i+1];
				int j = 0;
				while(st.hasMoreTokens()) {
					num[j++] = Integer.parseInt(st.nextToken());
				}
				bw.write(Output.substring(0, Output.length()-1) + "=" + ad.add(num) + "\n");
			}
		}
		bw.close();
		br.close();
	}
}
*/