import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    // 크루스칼
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;
         
        public Edge(int start, int end, int weight) {
            super();
            this.from = start;
            this.to = end;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight , o.weight);
        }
    }
     
    static Edge[] edgeList;
    static int[] parents;
    static int V,E;
     
    public static void make() {
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }
    public static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
     
    public static boolean union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
         
        parents[bRoot] = aRoot;
        return true;
    }   
     
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
         
        for(int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parents = new int[V];
            edgeList = new Edge[E];
             
            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());
       
                edgeList[i] = new Edge(from, to, weight);
            }
             
            make();
     
            Arrays.sort(edgeList);
            long result = 0;
            int count = 0;
            for(Edge edge : edgeList){
                if(union(edge.from, edge.to)){ 
                    result += edge.weight;
                    if(++count == V-1) break;
                     
                }
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }
}