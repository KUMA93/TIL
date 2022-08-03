import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline
sys.setrecursionlimit(10**6) # 500*500 250000*4 1000000

n=int(input())
board=[list(map(int, input().split())) for _ in range(n)]
ch=[[0]*n for _ in range(n)]
dx=[-1, 0, 1, 0]
dy=[0, -1, 0, 1]

def Panda(x, y):
    if ch[x][y]:
        return ch[x][y]
    ch[x][y]=1
    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
        if 0<=xx<n and 0<=yy<n and board[xx][yy]>board[x][y]:
            ch[x][y] = max(ch[x][y], Panda(xx, yy)+1)
    return ch[x][y]

res=0
for i in range(n):
    for j in range(n):
        res=max(res, Panda(i, j))
print(res)