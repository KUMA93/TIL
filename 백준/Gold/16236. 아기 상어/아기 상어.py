import sys
from collections import deque

def Set(x, y, size):
    dis=[[0]*n for _ in range(n)]
    visit=[[0]*n for _ in range(n)]
    visit[x][y]=1
    tmp=[]
    dq = deque()
    dq.append((x, y))
    while dq:
        now=dq.popleft()
        for i in range(4):
            nX=now[0]+dx[i]
            nY=now[1]+dy[i]
            if 0<=nX<n and 0<=nY<n and visit[nX][nY]==0:
                if board[nX][nY]<=size:
                    visit[nX][nY]=1
                    dis[nX][nY]=dis[now[0]][now[1]]+1
                    dq.append((nX,nY))
                    if 0<board[nX][nY]<size:
                        tmp.append((nX, nY, dis[nX][nY]))
    if tmp:
        tmp.sort(key=lambda x: (x[2], x[0], x[1]))
        return tmp[0]
    else:
        return False
n=int(input())
board=[]
ableTomove=[[0]*n for _ in range(n)]
ableToeat=[[0]*n for _ in range(n)]
dx=[-1,1,0,0]
dy=[0,0,-1,1] #상하좌우
size=2
cnt=0
Sum=0
for i in range(n):
    tmp=list(map(int, input().split()))
    for j in range(n):
        if tmp[j]==9:
            bX, bY=i, j
    board.append(tmp)
while True:
    shark=Set(bX, bY, size)
    if not shark:
        break
    nX, nY, dist=shark
    Sum+=dist
    board[bX][bY], board[nX][nY]=0, 0
    bX, bY=nX, nY
    cnt+=1
    if cnt==size:
        size+=1
        cnt=0
print(Sum)