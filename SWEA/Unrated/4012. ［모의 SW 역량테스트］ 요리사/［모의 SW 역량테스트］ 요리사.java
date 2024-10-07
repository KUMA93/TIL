import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int TC, N, R, minValue;
	static int[] input;
	static boolean[] table;
	static int[][] board;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			R = N/2;
			board = new int[N][N];
			table = new boolean[N];
			minValue = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			teaming(0);
			System.out.printf("#%d %d\n", t, minValue);
		}
	}
	
	public static void teaming(int cnt) {
		if (cnt == N) {
			int sum1 = 0;
			int sum2 = 0;
			
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					if (table[i] && table[j]) {
						sum1 += board[i][j] + board[j][i];
					}else if (!table[i] && !table[j]){
						sum2 += board[i][j] + board[j][i];
					}
				}
			}
			minValue = Math.min(minValue, Math.abs(sum1-sum2));
			return;
		}	
		table[cnt] = true;
		teaming(cnt + 1);
		table[cnt] = false;
		teaming(cnt + 1);
	}
}