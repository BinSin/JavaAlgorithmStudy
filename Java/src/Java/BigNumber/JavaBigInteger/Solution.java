package Java.BigNumber.JavaBigInteger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine();
		String b = br.readLine();
		BigInteger ab = new BigInteger(a);
		BigInteger bb = new BigInteger(b);
		
		bw.write(ab.add(bb).toString() + "\n");
		bw.write(ab.multiply(bb).toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
