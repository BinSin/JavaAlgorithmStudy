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
			if (aArr[aIndex] >= 'a' && aArr[aIndex] <= 'z') {
				if (bIndex >= b.length()) {
					aIndex++;
					continue;
				}
				
				int aLocation = aIndex + 1;
				int bLocation = bIndex;
				
				for (int i = aLocation; i < a.length(); i++) {
					if (aArr[i] >= 'a' && aArr[i] <= 'z') {
						aLocation++;
					} else
						break;
				}

				for (int i = bLocation; i < b.length(); i++) {
					if (bArr[i] != aArr[aLocation]) {
						bLocation++;
					} else
						break;
				}
				
				// daBcd
				// ABC
				
				// daB
				// AB
				// 이렇게
				
				
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
			return "YES";
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
