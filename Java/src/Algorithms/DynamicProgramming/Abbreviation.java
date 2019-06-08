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

		int bIndex = 0;
		for (int aIndex = 0; aIndex < a.length(); aIndex++) {
			if (aArr[aIndex] >= 'a' && aArr[aIndex] <= 'z') {
				if (bIndex >= b.length()) {
					continue;
				}

				aArr[aIndex] -= 32;
				if (aArr[aIndex] == bArr[bIndex]) {
					bIndex++;
					
/*
이 케이스에 대해 다시 생각해보자
1
bcBCASD
BCASD
YES 되야 한다.
*/
					for (int i = aIndex + 1; i < a.length(); i++) {
						if (aArr[i] >= 'a' && aArr[i] <= 'z') {
							if(aArr[aIndex] == aArr[i]) {
								aArr[i] += 32;
								break;
							}
							else
								continue;
						}
						else
							break;
					}
				}
			} else {
				if (bIndex >= b.length()) {
					return "NO";
				}

				if (aArr[aIndex] == bArr[bIndex]) {
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
