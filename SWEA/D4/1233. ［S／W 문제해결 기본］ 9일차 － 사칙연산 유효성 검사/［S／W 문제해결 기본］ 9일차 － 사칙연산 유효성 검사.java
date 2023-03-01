import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int tc = 1; tc <= 10; tc++) {
            int nodes = Integer.parseInt(br.readLine());
            int flag = 1;
             
            for (int i = 1; i <= nodes; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cur = Integer.parseInt(st.nextToken());
                String val = st.nextToken();
                while(st.hasMoreTokens()) {
                    int leftRight = Integer.parseInt(st.nextToken());
                }
                if(cur <= (nodes/2)) {
                    if (isInteger(val)) flag = 0;
                }else {
                    if (isOperator(val)) flag = 0;
                }
            }
            if (nodes%2 == 0) flag = 0;
            System.out.printf("#%d %d\n", tc, flag);
        }
    }
     
    public static boolean isInteger(String st) {
        try {
          Integer.parseInt(st);
          return true;
        } catch (NumberFormatException ex) {
          return false;
        }
    }
     
    public static boolean isOperator(String st) {
        if (st == "+" | st == "-" | st == "*" | st == "/") return true;
        else return false;
    }
}