import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Solution {
    static int TC, N, K;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
             
            Deque<Character> dq = new ArrayDeque<>();
            HashSet<String> res = new HashSet<>();
            ArrayList<Integer> fin = new ArrayList<>();
             
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                dq.offer(str.charAt(i));
            }
             
            for (int i = 0; i < N/4; i++) {
                StringBuilder sb = new StringBuilder();
                for (char ch : dq) {
                    sb.append(ch);
                    if (sb.length() == N/4) {
                        res.add(sb.toString());
                        sb.setLength(0);
                    }
                }
                 
                dq.offer(dq.pollFirst());
            }
             
            for (String s : res) {
                fin.add(Integer.parseInt(s, 16));
            }
             
            Collections.sort(fin, Collections.reverseOrder());
             
            System.out.printf("#%d %d\n", t, fin.get(K-1));
        }
         
         
    }
}