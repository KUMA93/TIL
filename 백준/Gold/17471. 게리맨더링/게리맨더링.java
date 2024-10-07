import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;

public class Main {
	static int N, ter, minVal;
	static int[] population, visited;
	static boolean[] isSelected;
	static boolean[][] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		minVal = Integer.MAX_VALUE;
		population = new int[N];
		isSelected = new boolean[N];
		adj = new boolean[N][N];
		
		// 인구 정보 입력 받기
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		// 인접 정보 입력 받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				adj[i][to] = true;
				adj[to][i] = true;
			}
		}
		
		devideTeri(0);
		if(minVal == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minVal);
	}
	
	public static void devideTeri(int cnt) {
		if(cnt == N) {
			visited = new int[N];
			ter = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i] == 0 && isSelected[i]) {
					ter++;
					bfs(i);
				}
				else if(visited[i] == 0 && !isSelected[i]) {
					ter++;
					bfs2(i);
				}
			}
			
			if(ter == 2) {
				int sumA = 0;
				int sumB = 0;
				for(int i = 0; i < N; i++) {
					if(visited[i] == 1) sumA += population[i];
					else sumB += population[i];
					
				}
				minVal = Math.min(minVal, Math.abs(sumA-sumB));
			}
			return;
		}
		isSelected[cnt] = true;
		devideTeri(cnt + 1);
		isSelected[cnt] = false;
		devideTeri(cnt + 1);
	}

	private static void bfs(int start) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(start);
		visited[start] = ter;
		
		while(!dq.isEmpty()) {
			int cur = dq.pollFirst();
			
			for (int i = 0; i < N; i++) {
				if (isSelected[i] && visited[i] == 0 && adj[cur][i]) {
					dq.offer(i);
					visited[i] = ter;
				}
			}
		}
	}
	
	private static void bfs2(int start) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(start);
		visited[start] = ter;
		
		while(!dq.isEmpty()) {
			int cur = dq.pollFirst();
			
			for (int i = 0; i < N; i++) {
				if (!isSelected[i] && visited[i] == 0 && adj[cur][i]) {
					dq.offer(i);
					visited[i] = ter;
				}
			}
		}
	}
}