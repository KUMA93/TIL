import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<Integer[]>[] adjList = new ArrayList[V+1];
		for (int i = 0; i < V+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			Integer[] tmp = {to, weight};
			
			adjList[from].add(tmp);
		}
		
		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[V+1]; // 출발정점에서 자신까지 오는 최소 비용
		boolean[] visited = new boolean[V+1]; // 경유지로 고려된 정점 여부
		
		Arrays.fill(distance, INF); // 최소값이 갱신 로직을 반영해야 하므로 큰값으로 초기화
		distance[start] = 0;
		
		int min, current, size;
		
		for (int i = 1; i < V+1; i++) {
			
			// step1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			current = -1;
			min = INF;
			
			for(int j = 1; j < V+1; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			if(current == -1) break;
			visited[current] = true;
			size = adjList[current].size();
			// step2 : 위에서 선택된 정점을 경유지로 해서 갈수 있는 다른 인접정점과의 비용 최소값 갱신
			for(int j = 0; j < size; j++) {
				Integer[] next = adjList[current].get(j);
				if(distance[next[0]] > min+next[1]) {
					distance[next[0]] = min+next[1];
				}
			}
		}
		
		for(int i = 1; i < V+1; i++) {
			System.out.println(distance[i] != INF ? distance[i] : "INF");
		}
	}
	

}