import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 검은색 스카프 최소 둘레
	 * 가로 세로 각각 100
	 * 검은색 스카프의 수는 100이하
	 * 왼쪽 아래가 좌표 기준
	 */
	
	// 검은색 스카프의 수 N, 흰 천을 나타내는 board, 4방 탐색을 위한 dx, dy
	static int N, sum;
	static int[][] board;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sum = 0;
		N = Integer.parseInt(st.nextToken());
		// 가장자리 좌표 값인 100에 검은 스카프가 놓이면 사방탐색 시 보드의 범위를 넘어가므로 사이즈를 1 더 늘려준다.
		board = new int[102][102];
		
		// 가장 큰 x좌표와 y좌표를 입력받으면서 저장
		int maxX = 0;
		int maxY = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			maxX = Math.max(maxX, x);
			maxY = Math.max(maxY, y);
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					board[x+j][y+k] = 1;
				}
			}
		}
		maxX+=10;
		maxY+=10;
		
		// 검은 스카프가 놓인 최대 범위까지 탐색하면서 검은 스카프가 놓인 곳이라면(board[i][j] == 1) 사방 탐색을 해서 0이 나오는 만큼 둘레길이에 1을 더해줌
		for (int i = 0; i <= maxX+1; i++) {
			for (int j = 0; j <= maxY+1; j++) {
				if(board[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if(board[x][y] == 0) sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}