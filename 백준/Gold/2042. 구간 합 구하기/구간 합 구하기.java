import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long[] nums = new long[N];
		tree = new long[N+1];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			update(i, nums[i-1]);
		}
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				update(b, c - nums[b-1]);
				nums[b-1] = c;
			}else {
				System.out.println(subSum(b, c));
			}
		}
	}

	public static void update(int i, long num) {
		while(i <= N) {
			tree[i] += num;
			i += (i & -i);	
		}
	}

	public static long sum(int i) {
		long ans = 0;
		while(i > 0) {
			ans += tree[i];
			i -= (i & -i);	
		}
		return ans;
	}

	public static long subSum(long start, long end) {
		return sum((int)end) - sum((int)(start-1));
	}
}