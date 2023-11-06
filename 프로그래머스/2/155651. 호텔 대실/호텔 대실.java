import java.util.*;

class Solution {

        static class book{
            int start;
            int end;

            public book(String start, String end) {
                String[] startTime = start.split(":");
                String[] endTime = end.split(":");

                int tmpStart = Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]);
                int tmpEnd = Integer.parseInt(endTime[0])*60 + Integer.parseInt(endTime[1]);

                this.start = tmpStart;
                this.end = tmpEnd + 10;
            }
        }

        public int solution(String[][] book_time) {
            int answer = 0;
            List<book> books = new ArrayList<>();
            Queue<Integer> room = new PriorityQueue<>();

            for (int i = 0; i < book_time.length; i++) {
                books.add(new book(book_time[i][0], book_time[i][1]));
            }

            books.sort(Comparator.comparingInt(o -> o.start));

            for (book now : books) {
                int start = now.start;
                // System.out.println(start);

                if (!room.isEmpty() && start < room.peek()) room.add(now.end);
                else {
                    room.poll();
                    room.add(now.end);
                }

            }

            answer = room.size();

            return answer;
        }
    }