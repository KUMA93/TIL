import sys
input = sys.stdin.readline

n = int(input())
board = [list(map(int, input().rstrip())) for _ in range(n)]
ch = [[0]*n for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def dfs(x, y):
    global cnt
    cnt+=1
    ch[x][y]=1
    for i in range(4):
        xx = x+dx[i]
        yy = y+dy[i]
        if 0<=xx<n and 0<=yy<n and board[xx][yy]==1 and not ch[xx][yy]:
            dfs(xx, yy)

res=[]

for i in range(n):
    for j in range(n):
        if board[i][j]==1 and not ch[i][j]:
            cnt = 0
            dfs(i, j)
            res.append(cnt)

print(len(res))
res.sort()
for x in res:
    print(x)