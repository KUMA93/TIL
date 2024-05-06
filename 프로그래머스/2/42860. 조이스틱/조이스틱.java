import java.util.*;

class Solution {
static int answer, len;

    public static class Word{
        String str;
        int idx;
        int cnt;

        public Word(String str, int idx, int cnt) {
            this.str = str;
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static int solution(String name) {
        answer = Integer.MAX_VALUE;
        len = name.length();

        String start = "";
        for (int i = 0; i < len; i++) start += 'A';

        bfs(new Word(start, 0, 0), name);


        return answer;
    }

    public static void bfs(Word w, String target) {

        Deque<Word> dq = new ArrayDeque<>();
        dq.offer(w);

        while (!dq.isEmpty()) {
            Word now = dq.pollFirst();

            // idx의 알파벳 변경
            String newStr = now.str;

            if (now.str.charAt(now.idx) != target.charAt(now.idx)) {
                now.cnt += calculateMoveCount(now.str.charAt(now.idx), target.charAt(now.idx));

                char[] chars = newStr.toCharArray();
                chars[now.idx] = target.charAt(now.idx);
                newStr = new String(chars);
            }

            if (newStr.equals(target)) {
                answer = now.cnt;
                break;
            }

            for (int i = -1; i < 2; i += 2) {
                int newIdx = (now.idx + i + len) % len;
                dq.offer(new Word(newStr, newIdx, now.cnt + 1));
            }
        }
    }

    // 알파벳을 변환하는 메서드
    // A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
    public static int calculateMoveCount(char from, char to) {
        int fromIndex = from - 'A';
        int toIndex = to - 'A';

        int moveCountLeft = Math.abs((fromIndex - toIndex + 26) % 26);
        int moveCountRight = Math.abs((toIndex - fromIndex + 26) % 26);

        return Math.min(moveCountLeft, moveCountRight);
    }
}
