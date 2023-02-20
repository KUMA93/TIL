import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, R, C, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		exp(0, 0, (int)Math.pow(2, N));
	}
	
	public static void exp(int r, int c, int size) {
		if(r == R && c == C) {
			System.out.println(cnt);
			return;
		}
		if(size == 1) {
			cnt++;
			return;
		}
		if (!(R >= r && R < r+size && C >= c && C < c+size)) {
			cnt += size*size;
			return;
		}
		int half = size / 2;
		exp(r, c, half);
		exp(r, c+half, half);
		exp(r+half, c, half);
		exp(r+half, c+half, half);
	}
}