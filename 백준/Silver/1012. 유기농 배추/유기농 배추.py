import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def dfs(x, y):
    ch[x][y] = 1
    for i in range(4):
        xx = x+dx[i]
        yy = y+dy[i]
        if 0<=xx<n and 0<=yy<m and board[xx][yy]==1 and not ch[xx][yy]:
            dfs(xx, yy)

for _ in range(int(input())):
    m, n, k = map(int, input().split())
    board = [[0]*m for _ in range(n)]
    ch = [[0]*m for _ in range(n)]
    cnt = 0

    for _ in range(k):
        x, y = map(int, input().split())
        board[y][x] = 1

    for i in range(n):
        for j in range(m):
            if board[i][j]==1 and not ch[i][j]:
                cnt+=1
                dfs(i, j)
    print(cnt)

