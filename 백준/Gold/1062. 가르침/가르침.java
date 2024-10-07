import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * N 50이하 자연수
 * K 26이하 자연수
 * 단어 소문자, 길이 8~15
 * 중복 x
 */

public class Main {
	static int N, K, maxValue;
	static boolean[] alpha = new boolean[26];
	static int[] selected;
	static ArrayList<Character>[] words;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new ArrayList[N];
		
		// 기본적으로 포함할 알파벳 5개 보다 K가 작으면 종료 
		if(K < 5) {
			System.out.println(0);
			System.exit(0);
		}
		// 종료 안됐으면 기본 알파벳 추가
		alpha[0] = true;
		alpha[2] = true;
		alpha[8] = true;
		alpha[13] = true;
		alpha[19] = true;
		// 조합 만들어줄 배열
		selected = new int[K-5];
		
		for(int i = 0; i < N; i++) {
			words[i] = new ArrayList<Character>();
		}
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			tmp = tmp.substring(4, tmp.length()-4);
			int size = tmp.length();
			
			for (int j = 0; j < size; j++) {
				if(!isBase(tmp.charAt(j))) {
					char word = tmp.charAt(j);
					words[i].add(word);
				}
			}
		}
		
		selectAlpha(0, 0);
		
		System.out.println(maxValue);
		
		
	}
	
	// a b c d e f g h i j k l m n o p q r s t u v w x y z
	public static boolean isBase(char c) {
		if (c == 'a' || c == 'c' || c == 'i' || c == 'n' || c == 't') return true;
		else return false;
	}
	
	public static void selectAlpha(int cnt, int start) {
		if (cnt == K-5) {
			maxValue = Math.max(maxValue, checkWord(alpha));
			return;
		}
		for (int i = start; i < 26; i++) {
			if (i == 0 || i == 2 || i == 8 || i == 13 || i == 19) continue;
			alpha[i] = true;
			selectAlpha(cnt + 1, i + 1);
			alpha[i] = false;
		}
	}
	
	public static int checkWord(boolean[] al) {
		int res = 0;
		for (int i = 0; i < N; i++) {
			int size = words[i].size();
			boolean flag = true;
			for (int j = 0; j < size; j++) {
				char cur = words[i].get(j);
				if(!al[cur-97]) flag = false;
			}
			if(flag) res++;
		}
		
		return res;
	}
}