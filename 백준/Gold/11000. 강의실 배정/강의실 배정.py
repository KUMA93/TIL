import sys
import heapq
input = sys.stdin.readline
lst = []
rooms = []

n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    lst.append((x, y))
lst.sort()
heapq.heappush(rooms, lst[0][1])

for i in range(1, n):
    x, y = lst[i][0], lst[i][1]
    if rooms[0] <= x:
        heapq.heappop(rooms)
        heapq.heappush(rooms, y)
    else :
        heapq.heappush(rooms, y)
print(len(rooms))