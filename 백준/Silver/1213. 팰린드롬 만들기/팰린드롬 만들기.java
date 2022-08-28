import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int size = input.length();

        int[] alpha = new int[26];
        for(int i=0; i<size; i++)
            alpha[input.charAt(i)-'A']++;

        int cnt = 0;
        int center = 0;
        for(int i=0; i<26; i++)
            if(alpha[i]%2!=0) {
                center = i;
                cnt++;
            }

        if(cnt>1 || (cnt==1 && size%2==0)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuffer result = new StringBuffer();
        for(int i=0; i<26; i++)
            for(int j=0; j<alpha[i]/2; j++)
                result.append((char)(i+'A'));
        StringBuffer tmp = new StringBuffer(result.toString());
        if(cnt==1) result.append((char)(center+'A'));
        System.out.println(result.toString()+tmp.reverse());
    }
}