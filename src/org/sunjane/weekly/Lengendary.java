package org.sunjane.weekly;

import java.util.Scanner;

public class Lengendary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int P = in.nextInt();
		int Q = in.nextInt();
		int N = in.nextInt();
		// double q = Q * 1.0 / 100;
		// double p = P * 1.0 / 100;

		double sum = 0;
		for (int i = 0; i < N; i++) {
			int tempP = P;
			double num = 0.0;
			int count = 1;
			double p = 1.0;
			while (tempP < 100) {
				num += count * p * (tempP / 100.0);
				count++;
				p *= (100 - tempP) / 100.0;
				tempP += Q;
			}
			num += count * p;
			P /= 2;
			sum += num;
		}
		System.out.printf("%.2f\n", sum);

	}

	private double calSum(int P, int Q, int N) {
		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			double num = 1.0; // must test one at first time
			int tempP = P; // success pro
			if (tempP < 100) {
				double cont = (100 - tempP) / 100.0;
				while (tempP < 100) {
					num += cont;
					tempP += Q;
					cont *= (100 - tempP) / 100.0;
				}
			}

			P /= 2;
			sum += num;
		}
		return sum;
	}

}
