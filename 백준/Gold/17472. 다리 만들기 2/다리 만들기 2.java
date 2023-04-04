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
/*
 * 다리의 길이는 2이상, 방향이 도중에 바뀌면 안 됨, 가로 또는 세로로만, 다리의 양 끝이 섬에 같은 방향으로 인접
 * 1 ≤ N, M ≤ 10
 * 3 ≤ N×M ≤ 100
 * 2 ≤ 섬의 개수 ≤ 6
 */
	static int N, M, MIN;
	static int[][] map;
	static boolean[][] visited;
	static int[] numbers;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<int[]> bridges;	// 길이, from, to
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MIN = Integer.MAX_VALUE;
		
		map = new int[N][M];
		visited = new boolean[N][M];
		bridges = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬에 번호 부여
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					map[i][j] = num;
					numberingIsland(i, j, num++);
					
				}
			}
		}
		num--;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					makeBridge(i, j, map[i][j]);
				}
			}
		}

//		for (int[] x : map) {
//			System.out.println(Arrays.toString(x));
//		}
		
		int size = bridges.size();
		numbers = new int[num-1];
		
//		for (int i = 0; i < size; i++) {
//			System.out.print(bridges.get(i)[0] + " " + bridges.get(i)[1] + " " + bridges.get(i)[2] + "\n");
//		}
		
		combination(0, 0, num, size);
		
		System.out.println((MIN == Integer.MAX_VALUE ? -1 : MIN));
		
	}
	
	// 초기 섬 스캔
	public static void numberingIsland(int x, int y, int num) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (!isInMap(nx, ny) || map[nx][ny] == 0 || visited[nx][ny]) continue;
			
			map[nx][ny] = num;
			visited[nx][ny] = true;
			numberingIsland(nx, ny, num);
		}
	}
	
	// 놓을 수 있는 다리 찾기
	public static void makeBridge(int x, int y, int from) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int rx = x - dx[i];
			int ry = y - dy[i];
			
			if (!isInMap(nx, ny) || map[nx][ny] == from || (map[nx][ny] == 0 && isInMap(rx, ry) && map[rx][ry] == 0)) {
				int cnt = 0;
				while(isInMap(rx, ry) && map[rx][ry] == 0) {
					rx -= dx[i];
					ry -= dy[i];
					cnt++;
				}
				
				if (isInMap(rx, ry) && map[rx][ry] != from && cnt > 1) {
					bridges.add(new int[] {cnt, from, map[rx][ry]});
				}
				
			}
		}
	}
	
	public static void combination(int cnt, int start, int N, int B) {
		if(cnt == N-1) {
			int sum = 0;
			// 유효성 검사
			if (isValid(numbers, N)) {
				// 거리 계산
				for (int x : numbers) {
					sum += bridges.get(x)[0];
				}
				
				MIN = Math.min(MIN, sum);
			}
			return;
		}
		for(int i = start; i < B; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1, N, B);
		}
	}
	
	public static boolean isValid(int[] numbers, int N) {
		boolean[] check = new boolean[N];
		ArrayList<Integer>[] adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int x : numbers) {
			adj[bridges.get(x)[1]-1].add(bridges.get(x)[2]-1);
			adj[bridges.get(x)[2]-1].add(bridges.get(x)[1]-1);
		}
		Deque<Integer> dq = new ArrayDeque();
		dq.offer(0);
		check[0] = true;
		
		while(!dq.isEmpty()) {
			int cur = dq.pollFirst();
			
			for (int next : adj[cur]) {
				if(!check[next]) {
					dq.offer(next);
					check[next] = true;
				}
			}
		}
		
		for (boolean x : check) {
			if (!x) return false;
		}
		return true;
	}
	
	public static boolean isInMap(int x, int y) {
		if ((0 <= x && x < N) && (0 <= y && y < M)) return true;
		return false;
	}
}