import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Solution {
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> password;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for(int testcase = 1; testcase <= 10; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            password = new ArrayDeque<Integer>(8);
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 8; i++) { 
                password.addLast(Integer.parseInt(st.nextToken()));
            }
             
            int phase = 1;
            while(true) {
                if(cycle(phase)) break;
                phase++;
                if(phase == 6) phase = 1;
            }
             
            System.out.printf("#%d ", testcase);
            for (int word : password) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
     
    public static boolean cycle(int num) {
        int cur = password.pollFirst()-num;
        if(cur <= 0) {
            cur = 0;
            password.addLast(cur);
            return true;
        }else {
            password.addLast(cur);
            return false;
        }
    }
}