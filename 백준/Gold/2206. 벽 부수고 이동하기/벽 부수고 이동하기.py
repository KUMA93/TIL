import sys
input = sys.stdin.readline
from collections import deque

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

n, m = map(int, input().split())
shortest = 2147000000
board = [list(map(int, input().strip())) for _ in range(n)]
visited = [[[0]*2 for _ in range(m)] for _ in range(n)]

def bfs(a, b, c):
    dq = deque()
    dq.append((a, b, c))
    visited[a][b][c] = 1

    while dq:
        x, y, brk = dq.popleft()

        if brk > 1:
            return

        if x == n-1 and y == m-1:
            return visited[x][y][brk]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if board[nx][ny] == 1 and brk == 0:
                    visited[nx][ny][brk+1] = visited[x][y][brk] + 1
                    dq.append((nx, ny, brk+1))
                elif board[nx][ny] == 0 and visited[nx][ny][brk] == 0:
                    visited[nx][ny][brk] = visited[x][y][brk] + 1
                    dq.append((nx, ny, brk))
    return -1

print(bfs(0, 0, 0))

# for x in visited:
#     for y in x:
#         print(y, end=" ")
#     print()