import java.util.*;

class Solution {
    // 장르 총합 -> 그 안에서 많이 재생된 순서 -> 재생 횟수가 같은 것은 고유번호가 작은 노래부터 2개씩
    
    static class Song implements Comparable<Song>{
        int num, play;
        
        public Song(int num, int play) {
            this.num = num;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song o) {
            if (this.play != o.play) return o.play - this.play;
            else return this.num - o.num;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, Integer> genrePlay = new HashMap<>();
        Map<String, Set<Song>> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genrePlay.put(genres[i], genrePlay.getOrDefault(genres[i], 0) + plays[i]);
            map.computeIfAbsent(genres[i], key -> new TreeSet<>()).add(new Song(i, plays[i]));
        }
        
        List<String> genreOrder = new ArrayList<>(genrePlay.keySet());
        genreOrder.sort((o1, o2) -> genrePlay.get(o2) - genrePlay.get(o1));
        
        for (String key : genreOrder) {
            int limit = 0;
            for (Song now : map.get(key)) {
                if(limit == 2) break;
                result.add(now.num);
                limit++;
            }
        }
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}