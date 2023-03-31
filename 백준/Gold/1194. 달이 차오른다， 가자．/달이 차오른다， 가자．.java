import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, res;
	static char[][] map;
	static Deque<int[]> dq;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static ArrayList<Character> lowercase = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'));
	static ArrayList<Character> uppercase = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F'));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dq = new ArrayDeque();
		res = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == '0')
					dq.offer(new int[] { i, j, 0, 0 });
			}
		}
		bfs();
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

	public static void bfs() {
		boolean[][][] visited = new boolean[N][M][1 << 6];

		while (!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			int x = cur[0];
			int y = cur[1];
			int cnt = cur[3];

			if (map[x][y] == '1') {
				res = Math.min(res, cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int key = cur[2];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#' || visited[nx][ny][key])
					continue;

				// 소문자
				if (lowercase.contains(map[nx][ny])) {
					int newKey = map[nx][ny] - 'a';
					key |= (1 << newKey);
				}
				// 대문자
				else if (uppercase.contains(map[nx][ny])) {
					int door = map[nx][ny] - 'A';
					if ((key & (1 << door)) == 0)
						continue;
				}

				dq.offer(new int[] { nx, ny, key, cnt + 1 });
				visited[nx][ny][key] = true;

			}
		}

	}
}