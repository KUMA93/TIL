import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] swt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		swt = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			swt[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			turn(sex, num);
			
			
		}
	int idx = 0;
	for (int i = 0; i<n; i++) {
		System.out.print(swt[i] + " ");
		idx++;
		if(idx%20==0) {
			idx = 0;
			System.out.println();
		}
	}
	System.out.println();
		
	}
	private static int reverse(int state) {
		if(state == 1) return 0;
		else return 1;
	}
	
	private static void turn(int sex, int num) {
		if (sex==1) {
			for (int i=0; i<n; i++) {
				if((i+1)%num==0) {
					swt[i]=reverse(swt[i]);
				}
			}
		}else {
			int idx = num-1;
			swt[idx]=reverse(swt[idx]);
			int fwd = idx+1;
			int back = idx-1;
			while(true) {
				if (fwd < n && back >= 0 ) {
					if (swt[fwd] == swt[back]) {
						swt[fwd] = reverse(swt[fwd]);
						swt[back] = reverse(swt[back]);
						fwd++;
						back--;
					}else {
						break;
					}
				}else {
					break;
				}
			}
		}
	}
}