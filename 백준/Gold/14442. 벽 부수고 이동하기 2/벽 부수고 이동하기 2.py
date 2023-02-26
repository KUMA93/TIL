import sys
input = sys.stdin.readline
from collections import deque

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

n, m, k = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(n)]
visited = [[[0]*m for _ in range(n)] for _ in range(k+1)]
shortest = sys.maxsize

def bfs(a, b, c):
    global shortest
    dq = deque()
    dq.append((a, b, c))
    visited[c][a][b] = 1

    while dq:
        x, y, brk = dq.popleft()

        if brk > k:
            return

        if x == n-1 and y == m-1:
            return visited[brk][x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if board[nx][ny] == 1 and brk < k and visited[brk+1][nx][ny] == 0:
                    visited[brk+1][nx][ny] = visited[brk][x][y] + 1
                    dq.append((nx, ny, brk+1))
                elif board[nx][ny] == 0 and visited[brk][nx][ny] == 0:
                    visited[brk][nx][ny] = visited[brk][x][y] + 1
                    dq.append((nx, ny, brk))
    return -1

print(bfs(0, 0, 0))