import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
	
	/*
	 * 0 ≤ N ≤ 100,000
	 * 0 ≤ K ≤ 100,000
	 * 수빈이 걷거나 순간이동
	 * 위치가 X 
	 * 걸으면 X-1 or X+1
	 * 순간이동하면 2*X
	 */
	
	static int N, K, MAX, minValue;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		MAX = 100000;
		visited = new int[100001];
		Arrays.fill(visited, -1);
		minValue = Integer.MAX_VALUE;
		
		bfs(N, 0);
		System.out.println(minValue);
	}
	
	public static void bfs(int x, int cnt) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(x);
		visited[x] = cnt;
		
		while(!dq.isEmpty()) {
			int cx = dq.pollFirst();
			if (cx == K) {
				minValue = Math.min(minValue, visited[cx]);
				return;
			}
			int nx;
			nx = cx*2;
			if(nx <= MAX && visited[nx]==-1) {
				visited[nx] = visited[cx]+1;
				dq.offer(nx);
			
			}
			 
			nx = cx-1;
			if(nx >= 0 && visited[nx]==-1) {
				visited[nx] = visited[cx]+1;
				dq.offer(nx);
				
			}
				 
			nx = cx+1;
			if(nx <= MAX && visited[nx]==-1) {
				visited[nx] = visited[cx]+1;
				dq.offer(nx);
				
			}
			
		}
		
	}
}