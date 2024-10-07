import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[3] = 1;
		if(n == 4) {
			System.out.println(-1);
			System.exit(0);
		}
		if(n > 4) {
			dp[5] = 1;
		}
		
		for(int i = 6; i < n+1; i++) {
			if(dp[i-3] != -1 && dp[i-5] != -1)
				dp[i] = Math.min(dp[i-3] + 1, dp[i-5] + 1);
			else if(dp[i-3] != -1)
				dp[i] = dp[i-3] + 1;
			else if(dp[i-5] != -1)
				dp[i] = dp[i-5] + 1;
		}
				
		
		System.out.println(dp[n]);
	}
	
}