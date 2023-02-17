import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] board;
	static LinkedList<int[]> house, chicken;
	static int[] check;
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		check = new int[M];
		house = new LinkedList<>();
		chicken = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					int[] tmp = new int[] {i, j};
					house.add(tmp);
				}else if (board[i][j] ==2) {
					int[] tmp = new int[] {i, j};
					chicken.add(tmp);
				}
			}
		}
		
		dfs(0, 0);
		System.out.println(res);
	}
	
	public static void dfs(int Lv, int start) {
		if(Lv == M) {
			int Sum = 0;
			for (int i = 0, size = house.size(); i < size; i++) {
				int x1 = house.get(i)[0];
				int y1 = house.get(i)[1];
				int dt = Integer.MAX_VALUE;
				for (int x : check) {
					int x2 = chicken.get(x)[0];
					int y2 = chicken.get(x)[1];
					dt = Math.min(dt, Math.abs(x2-x1)+Math.abs(y2-y1));
				}
				Sum += dt;
			}
			res = Math.min(res, Sum);
		} 
		else {
			for (int i = start, size = chicken.size(); i < size; i++) {
				check[Lv] = i;
				dfs(Lv+1, i+1);
			}
		}
	}
}