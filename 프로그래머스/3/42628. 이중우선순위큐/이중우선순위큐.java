import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String o : operations) {
            String[] part = o.split(" ");
            int value = Integer.parseInt(part[1]);
            if (part[0].equals("I")) {
                minHeap.add(value);
                maxHeap.add(value);
            }else {
                if (minHeap.isEmpty() || maxHeap.isEmpty()) continue;
                
                if (value == 1) {            
                    int val = maxHeap.poll();
                    minHeap.remove(val);
                }else {
                    int val = minHeap.poll();
                    maxHeap.remove(val);
                }
            }
        }
        if (minHeap.isEmpty() || maxHeap.isEmpty()) return new int[]{0, 0};
        else return new int[]{maxHeap.poll(), minHeap.poll()};
        
    }
}