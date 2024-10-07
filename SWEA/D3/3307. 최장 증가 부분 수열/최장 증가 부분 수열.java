import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, TC;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			int[] LIS = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int k = 0;
			LIS[k++] = arr[0];
			
			for (int i = 1; i < N; i++) {
				int tmp = Arrays.binarySearch(LIS, 0, k, arr[i]);
				tmp = Math.abs(tmp) -1;
				LIS[tmp] = arr[i];
				if(tmp == k) {
					k++;
				}
			}
			
			System.out.printf("#%d %d\n", t, k);
		}
	}
}