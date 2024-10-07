import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, N;
	static char[] cand;
	static boolean[] selected;
	/*
	 * 3 ≤ L ≤ C ≤ 15
	 * 암호조건  1. 서로 다른 L개의 알파벳 소문자
	 * 		  2. 모음(a, e, i, o, u) 최소 한 개, 자음 최소 두 개
	 * 		  3. 증가하는 순서
	 * C가지의 암호 
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		selected = new boolean[N];
		cand = new char[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cand[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(cand);
		
		selectWord(0, 0);
	}
	
	public static void selectWord(int cnt, int start) {
		if (cnt == R) {
			ArrayList<Character> tmp = new ArrayList<>();
			for (int i = 0; i < N; i ++) {
				if(selected[i]) tmp.add(cand[i]);
			}
			if(isValid(tmp)) {
				for(int i = 0; i < R; i++) {
					System.out.print(tmp.get(i));
				}
				System.out.println();
			}
			return;
		}
		for (int i = start; i < N; i++) {
			selected[i] = true;
			selectWord(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

	private static boolean isValid(ArrayList<Character> c) {
		int vowels = 0;
		int consonants = 0;
		for (int i = 0; i < R; i++) {
			char ch = c.get(i);
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowels++;
			else consonants++;
		}
		if(vowels >= 1 && consonants >= 2) return true;
		else return false;
	}
	
}