import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][][] visited = new long[N][N][3];
		
		visited[0][1][0] = 1;
		for (int i = 2; i < N; i++) {
			if(map[0][i] == 1) continue;
			visited[0][i][0] = visited[0][i-1][0];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if(map[i][j] == 1) continue;
				visited[i][j][0] = visited[i][j-1][0] + visited[i][j-1][2];
				visited[i][j][1] = visited[i-1][j][1] + visited[i-1][j][2];
				if(map[i-1][j] != 1 && map[i][j-1] != 1) {
					visited[i][j][2] = visited[i-1][j-1][0] + visited[i-1][j-1][1] + visited[i-1][j-1][2];
				}
			}
		}
		System.out.println(visited[N-1][N-1][0] + visited[N-1][N-1][1] + visited[N-1][N-1][2]);
	}
		
}