import sys
from collections import deque
input=sys.stdin.readline

board=[list(map(int, input().split())) for _ in range(3)]
dq=deque()
dx=[-1, 0, 1, 0]
dy=[0, -1, 0, 1]

def BFS():
    while dq:
        now=dq.popleft()
        if now == "123456789":
            print(dt[now])
            return
        idx=now.find('9')
        x, y = idx//3, idx%3

        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]
            if 0 <= xx < 3 and 0 <= yy < 3:
                target_idx = 3 * xx + yy
                nextNum=list(now)
                nextNum[target_idx], nextNum[idx] = nextNum[idx], nextNum[target_idx]
                nextNum = ''.join(nextNum)
                if not dt.get(nextNum):
                    dt[nextNum]=dt[now]+1
                    dq.append(nextNum)
    print(-1)

dt={}
start = ""
for i in range(3):
    for j in range(3):
        if board[i][j]==0:
            board[i][j]=9
        start += str(board[i][j])
dq.append(start)
dt[start]=0
BFS()