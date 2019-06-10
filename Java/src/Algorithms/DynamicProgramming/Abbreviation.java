package Algorithms.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Abbreviation {

	private static String abbreviation(String a, String b) {
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();

		int aIndex = 0, bIndex = 0;
		for (aIndex = 0; aIndex < a.length() && bIndex < b.length();) {
			if (bIndex == b.length()) {
				break;
			}
			
			if (aArr[aIndex] >= 'a' && aArr[aIndex] <= 'z') {
				if (bIndex >= b.length()) {
					aIndex++;
					continue;
				}

				int aLocation = aIndex;
				int bLocation = bIndex;

				for (int i = aLocation; i < a.length(); i++) {
					if (aArr[i] >= 'a' && aArr[i] <= 'z') {
						aLocation++;
					} else
						break;
				}
				
				if(aLocation != a.length()) {
					for (int i = bLocation; i < b.length(); i++) {
						if (bArr[i] == aArr[aLocation]) {
							break;
						}
						bLocation++;
					}
				}
				else {
					aLocation = a.length() - 1;
					bLocation = b.length() - 1;
				}
				
				int count = 0;
				for (int i = aIndex, j = bIndex; i <= aLocation && j <= bLocation; i++) {
					if (aArr[i] >= 'a' && aArr[i] <= 'z') {
						aArr[i] -= 32;
					}
					
					if(aArr[i] == bArr[j]) {
						j++;
						count++;
					}
					
					if(count == bLocation - bIndex + 1)
						break;
				}
				
				if(count != bLocation - bIndex + 1)
					return "NO";

				aIndex = aLocation + 1;
				bIndex = bLocation + 1;

			} else {
				if (bIndex >= b.length()) {
					return "NO";
				}

				if (aArr[aIndex] == bArr[bIndex]) {
					aIndex++;
					bIndex++;
				} else {
					return "NO";
				}
			}
		}

		if (bIndex == b.length()) {
			if(aIndex != a.length()) {
				for(int i=aIndex; i<a.length(); i++) {
					if(aArr[i] >= 'A' && aArr[i] <= 'Z')
						return "NO";
				}
				return "YES";
			} else {
				return "YES";
			}
		} else {
			return "NO";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int q = Integer.parseInt(br.readLine());

		for (int i = 0; i < q; i++) {
			String a = br.readLine();
			String b = br.readLine();

			bw.write(abbreviation(a, b) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
