import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N,M,start,end,cur,answer,arr[];
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            start=0;
            end=N-1;
            answer=-1;
            arr=new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            while(start!=end) {
                int add =arr[start]+arr[end];
                if(add>M) 
                    end--;
                else {
                    cur=arr[start]+arr[end];
                    answer=answer>cur?answer:cur;
                    start++;
                }
            }
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
    }
}