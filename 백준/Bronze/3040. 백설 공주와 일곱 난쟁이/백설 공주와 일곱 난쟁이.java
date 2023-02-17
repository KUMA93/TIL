import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N = 9;
	static int R = 7;
	static int[] dwarf, selected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarf = new int[N];
		selected = new int[R];
		
		for(int i = 0; i < N; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += selected[i];
			}
			if (sum == 100) {
				for (int i = 0; i < R; i++) {
					System.out.println(selected[i]);
				}
			}
		}
		else {
			for(int i = start; i < N; i++) {
				selected[cnt] = dwarf[i];
				comb(cnt + 1, i + 1);
			}
		}
	}
}