package Excel_Reading;

import java.util.Scanner;

public class arraytwoD {

	public static void main(String[] args) {

		int n = 1;
		Scanner sc = new Scanner(System.in);
		int p[][] = new int[n][];
		
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt(); // Taking input from user in JAVA.
			p[i] = new int[m]; // Allocating memory block of 'm' int size block.

			for (int j = 0; j < m; j++) {
				p[i][j] = sc.nextInt(); // Initializing 2D array block.
			}
		}

	}

}
