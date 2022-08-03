import sys
sys.stdin=open("input.txt", "rt")
from collections import deque
input=sys.stdin.readline

n, m=map(int, input().split()) # 3이상 300이하
board=[list(map(int, input().split())) for _ in range(n)] # 각 요소는 0이상 10이하
dx=[-1, 0, 1, 0]
dy=[0, -1, 0, 1]
year=[[0]*m for _ in range(n)]
dq=deque()
res=0
# 존재 하는 빙산 탐색-> 이어져 있는 빙산 탐색, cnt 증가
# 1년마다 인접한 바닷물의 수만큼 빙산 높이 낮아짐 - while 문으로 혹은 for문 10까지 돌리면 될듯 <- 이게 문제였음.. 10이 아니라 n,m의 값에 따라 얼마든지 반복횟수가 늘어날 수 있는걸 간과함

def glacialMount(a, b):
    dq.append((a, b))
    while dq:
        x, y=dq.popleft()
        ch[x][y]=1
        for i in range(4):
            xx=x+dx[i]
            yy=y+dy[i]
            if 0<=xx<n and 0<=yy<m:
                if board[xx][yy]>0 and ch[xx][yy]==0:
                    ch[xx][yy]=1
                    dq.append((xx, yy))
                elif board[xx][yy]==0:
                    year[x][y]+=1
    return

while True:
    ch=[[0]*m for _ in range(n)]
    year=[[0]*m for _ in range(n)]
    cnt=0
    for i in range(1, n-1):
        for j in range(1,m):
            if board[i][j]>0 and ch[i][j]==0:
                cnt+=1
                glacialMount(i, j)
    for i in range(n):
        for j in range(m):
            board[i][j]-=year[i][j]
            if board[i][j]<0:
                board[i][j]=0
    if cnt==0:
        print(0)
        break
    if cnt>=2:
        print(res)
        break
    res+=1
