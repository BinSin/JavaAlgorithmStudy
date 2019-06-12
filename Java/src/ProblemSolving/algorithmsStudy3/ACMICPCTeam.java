/*
 * Author : BinSin
 * https://www.hackerrank.com/challenges/acm-icpc-team
 */

package ProblemSolving.algorithmsStudy3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ACMICPCTeam {
	
	public static void maxNumberOfTopicAndCount(BigInteger[] teamKnow, int personNum, int topicNum) {
		int maxBitCount = 0;
		int maxScoreCount = 0;
		BigInteger score;
		
		for(int i=0; i<personNum-1; i++) {
			for(int j=i+1; j<personNum; j++) {
				score = teamKnow[i].or(teamKnow[j]);
				int bitCount = score.bitCount();
				if(bitCount > maxBitCount) {
					maxBitCount = bitCount;
					maxScoreCount = 1;
				}
				else if(bitCount == maxBitCount) {
					maxScoreCount++;
				}
			}
		}
		System.out.println(maxBitCount);
		System.out.println(maxScoreCount);
	}
	
	
	public static void main(String[] args) throws IOException {
		// Scanner ���� nextBigInteger��� �޼��尡 �ִ�
		// Scanner ���� 2������ nextBigInteger(2)�� ǥ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] s = str.split("\\s+");
		int personNum = Integer.parseInt(s[0]);
		int topicNum = Integer.parseInt(s[1]);
		
		BigInteger[] teamKnow = new BigInteger[personNum];
		for(int i=0; i<personNum; i++) {
			String topic = br.readLine();
			// �ڿ� 2�� ���̸� 2������ ����Ѵ�.
			teamKnow[i] = new BigInteger(topic, 2);
		}
		maxNumberOfTopicAndCount(teamKnow, personNum, topicNum);
	}
}