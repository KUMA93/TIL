import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 물고기 M마리, 상어 1마리
	 * 상어 이동 - 물고기보다 큰 경우: 먹고 이동
	 * 			물고기와 같은 경우: 이동
	 * 			물고기보다 작은 경우: x
	 * 물고기 여러마리일 때 - 가장 가까운, 가장 위쪽, 가장 왼쪽부터
	 * 물고기 자기 크기만큼 먹으면 크기 + 1
	 * 2 ≤ N ≤ 20
	 */
	static int N, M, startX, startY, min, minX, minY, res, size;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static class shark{
		int x;
		int y;
		int size;
		int time;
		public shark(int x, int y, int size, int time) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.time = time;
		}
	}
	
	static class dest{
		int x;
		int y;
		public dest(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		res = 0;
		size = 2;
		N = Integer.parseInt(br.readLine());
		M = 0;
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = true;
		while(flag) {
			Loop:
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 9){
						map[i][j] = 0;
						flag = findFish(new shark(i, j, size, 0));
						break Loop;
					}
				}
			}
		}
		System.out.println(res);
	}
	
	public static boolean findFish(shark sk) {
		min = Integer.MAX_VALUE;
		minX = -1;
		minY = -1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0 && map[i][j] < sk.size) {	
					bfs(sk, new dest(i, j));
				}
			}
		}
		
		if(minX == -1 && minY ==-1) return false;
		map[minX][minY] = 9;
		res += min;
		M++;
		if(M == size) {
			M = 0;
			size++;
		}
		return true;
	}
	
	public static void bfs(shark sk, dest d) {
		int dt = -1;
		visited = new boolean[N][N];
		Deque<shark> dq = new ArrayDeque<>();
		dq.add(sk);
		visited[sk.x][sk.y] = true;
		
		while(!dq.isEmpty()) {
			shark cur = dq.pollFirst();
			
			if(cur.x == d.x && cur.y == d.y) {
				 if (min > cur.time) {
					 min = cur.time;
					 minX = cur.x;
					 minY = cur.y;
				 }else if (min == cur.time) {
					 if (minX > cur.x) {
						 minX = cur.x;
						 minY = cur.y;
					 }else if (minX == cur.x && minY > cur.y) {
						 minX = cur.x;
						 minY = cur.y;
					 }
				 }
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= N || visited[nx][ny]) continue;
				
				if(map[nx][ny] <= cur.size) {
					dq.offer(new shark(nx, ny, cur.size, cur.time+1));
					visited[nx][ny] = true;
				}
			}
		}
		return;
	}
}