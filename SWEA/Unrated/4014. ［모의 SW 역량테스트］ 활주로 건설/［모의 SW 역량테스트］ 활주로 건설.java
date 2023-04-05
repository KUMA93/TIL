import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	/*
	 * 6 ≤ N ≤ 20
	 * 경사로의 높이는 항상 1 이고, 길이 X 는 2 이상 4 이하의 정수
	 * 지형의 높이는 1 이상 6 이하
	 * 
	 */
	static int TC, N, X;
	static int[][] map;
	static boolean[][] isHwal;
	static int[] dx = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			isHwal = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int i = 0;
			int cnt = 0;
			Loop1:
			while(i < N) {
				int j = 0;
				int cur = map[i][j];
				while(j < N) {
					if (cur == map[i][j]) j++;
					else if (cur == map[i][j] + 1) {
						int nx = i;
						int ny = j;
						
						for (int s = 0; s < X; s++) {
							if (!isInMap(nx, ny) || map[nx][ny] != map[i][j]) {
								i++;
								continue Loop1;
							}
							ny++;
						}
						
						for (int s = 0; s < X; s++) {
							isHwal[i][j+s] = true;
						}
						cur = map[i][j];
						if(j + X < N)
							j += X;
					}
					else if (cur == map[i][j] - 1) {
						int nx = i;
						int ny = j;
						
						for (int s = 0; s < X; s++) {
							ny--;
							if (!isInMap(nx, ny) || map[nx][ny] != map[i][j-1] || isHwal[nx][ny]) {
								i++;
								continue Loop1;
							}
						}
						
						for (int s = 0; s < X; s++) {
							isHwal[i][j-s-1] = true;
						}
						cur = map[i][j];
						if(j != N-1)
							j++;
					}
					else {
						i++;
						continue Loop1;
					}
					
					if(j == N) {
						cnt++;
						i++;
						continue Loop1;
					}
				}
				
				i++;
			}
			
			isHwal = new boolean[N][N];
			i = 0;
			int j = 0;
			Loop2:
				while(j < N) {
					i = 0;
					int cur = map[i][j];
					while(i < N) {
						if (cur == map[i][j]) i++;
						else if (cur == map[i][j] + 1) {
							int nx = i;
							int ny = j;
							
							for (int s = 0; s < X; s++) {
				                if (!isInMap(nx, ny) || map[nx][ny] != map[i][j]) {
				                    j++;
				                    continue Loop2;
				                }
				                nx++;
				            }
				            
				            for (int s = 0; s < X; s++) {
				                isHwal[i+s][j] = true;
				            }
				            cur = map[i][j];
				            if(i + X < N)
				                i += X;
				        }
				        else if (cur == map[i][j] - 1) {
				            int nx = i;
				            int ny = j;
				            
				            for (int s = 0; s < X; s++) {
				                nx--;
				                if (!isInMap(nx, ny) || map[nx][ny] != map[i-1][j] || isHwal[nx][ny]) {
				                    j++;
				                    continue Loop2;
				                }
				            }
				            
				            for (int s = 0; s < X; s++) {
				                isHwal[i-s-1][j] = true;
				            }
				            cur = map[i][j];
				            if(i != N-1)
				                i++;
				        }
				        else {
				            j++;
				            continue Loop2;
				        }
				        
				        if(i == N) {
				            cnt++;
				            j++;
				            continue Loop2;
				        }
				    }
				    
				    j++;
				}
			
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
	
	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < N) && (0 <= y && y < N);
	}
}