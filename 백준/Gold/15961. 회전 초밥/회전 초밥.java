import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c;
	static int[] sushi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N+k];
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N+k; i++) {
			sushi[i] = sushi[i-N];
		}
//		System.out.println(Arrays.toString(sushi));
		
		LinkedList<Integer> pick = new LinkedList<>();
		HashMap<Integer, Integer> check = new HashMap<>();
		int max = 0;
		
		for (int i = 0; i < k; i++) {
			pick.add(sushi[i]);
			if(check.get(sushi[i]) == null) {
				check.put(sushi[i], 1);
			}else {
				check.replace(sushi[i], check.get(sushi[i]) + 1);
			}
		}
		
		int size = check.keySet().size();
		if (max < size) {
			if (check.get(c) == null) {
				max = size + 1;
			}
			else {
				max = size;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(check.get(pick.get(0)) == 1) {
				check.remove(pick.get(0));
			}else {
				check.replace(pick.get(0), check.get(pick.get(0)) - 1);
			}
			pick.remove(0);
			
			if(check.get(sushi[i + k]) == null) {
				check.put(sushi[i + k], 1);
			}else {
				check.replace(sushi[i + k], check.get(sushi[i + k]) + 1);
			}
			pick.add(sushi[i+k]);
			
			size = check.keySet().size();
			if (max <= size) {
				if (check.get(c) == null) {
					max = size + 1;
				}
				else {
					max = size;
				}
			}
			
//			System.out.println("사이즈는 " + size);
//			check.forEach((key, value) -> {	
//				System.out.println(key + " : " + value);	
//			});
//			System.out.printf("%d번째부터 %d개까지 종류는 %d\n", i+1, k, max );
//			for (int f = 0; f < k; f++) {
//				System.out.print(pick.get(f) + " ");
//			}
//			System.out.println();
		}
		
		System.out.println(max);
	}

}