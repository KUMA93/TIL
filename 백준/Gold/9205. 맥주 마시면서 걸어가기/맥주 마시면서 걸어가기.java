import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int TC, N;
	static pos[] conb;
	static pos home;
	static Deque<pos> dq;
	/* 
	 * 한 박스 맥주 20개
	 * 50미터에 한 병
	 * 편의점에서 리필 가능
	 * -32768 ≤ x, y ≤ 32767
	*/
	
	static class pos {
		int x, y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			conb = new pos[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			home = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for (int i = 0; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				conb[i] = new pos(x, y);
				
			}
			
			dq = new ArrayDeque();
			dq.offer(home);
			bfs();
			
			
		}
		
	}
	
	public static void bfs() {
		boolean[] visited = new boolean[N+1];
		
		while(!dq.isEmpty()) {
			pos cur = dq.pollFirst();
			int x = cur.x;
			int y = cur.y;
			
			if (x == conb[N].x && y == conb[N].y) {
				System.out.println("happy");
				return;
			}
			
			for (int i = 0; i < N+1; i++) {
				if (visited[i]) continue;
				if (getDistance(cur, conb[i]) <= 1000) {					
					dq.offer(conb[i]);
					visited[i] = true;
				}
			}
		}
		
		System.out.println("sad");
	}
	
	public static int getDistance(pos a, pos b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y); 
	}
}