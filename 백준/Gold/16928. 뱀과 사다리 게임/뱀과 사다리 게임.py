import sys
input = sys.stdin.readline
from collections import deque

# 10*10 보드에 1~100 수 한 개씩
# 사다리에 도착시 사다리 타기
# 뱀에 도착시 뱀 따라서 내려가기
# 100번 초과시 이동불가

def bfs():
    global res
    dq = deque()
    dq.append((0, 0))
    visited = [False] * 100
    visited[0] = True

    while dq:
        now, cnt = dq.popleft()
        if now == 99:
            res = cnt
            return
        for i in range(1, 7):
            next = now + i
            if next > 99 or visited[next]:
                continue
            if board[next]:
                visited[next] = True
                visited[board[next]] = True
                dq.append((board[next], cnt+1))
            else:
                visited[next] = True
                dq.append((next, cnt+1))


board = [0]*100
N, M = map(int, input().split())
# ladder = [list(map(int, input().split())) for _ in range(N)]
# snake = [list(map(int, input().split())) for _ in range(M)]

for _ in range(N):
    x, y = map(int, input().split())
    board[x-1] = y-1

for _ in range(M):
    x, y = map(int, input().split())
    board[x-1] = y-1

bfs()
print(res)
