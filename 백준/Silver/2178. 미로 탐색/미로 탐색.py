import sys
input = sys.stdin.readline
from collections import deque


dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

n, m = map(int, input().split())
board = [list(map(int, input().rstrip())) for _ in range(n)]

def bfs(x, y):
    dq = deque()
    dq.append((x, y))

    while dq:
        x, y = dq.popleft()
        for i in range(4):
            xx = x+dx[i]
            yy = y+dy[i]
            if 0<=xx<n and 0<=yy<m and board[xx][yy]==1:
                board[xx][yy] = board[x][y] + 1
                dq.append((xx, yy))

    return board[n-1][m-1]

print(bfs(0, 0))