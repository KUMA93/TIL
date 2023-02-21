import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[][] board;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		br.close();
		
		quadTree(0, 0, N);
		
		System.out.println(sb);
	}
	
	
	public static void quadTree(int x, int y, int size) throws IOException {

		int checkNum = board[x][y];
		// 사이즈 안의 원소들이 모두 같은 값인지 검사
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(board[i][j] != checkNum) {
					checkNum = -1;
					break;
				}
			}
		}
		// 결과에 따라 분기
		if (checkNum == -1) {
			int half = size / 2;
			sb.append("(");
			quadTree(x, y, half);
			quadTree(x, y+half, half);
			quadTree(x+half, y, half);
			quadTree(x+half, y+half, half);			
			sb.append(")");
		}else if (checkNum == 1) {
			sb.append(1);
		}else sb.append(0);
	}
}