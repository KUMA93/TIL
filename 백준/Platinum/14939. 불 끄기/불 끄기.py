import sys
input=sys.stdin.readline
from itertools import product
# 우선 모양을 점검해볼 필요가 있다. 스위치는 다음 모양의 상태를 모두 바꾼다
#  O
# OOO
#  O
# 스위치는 단 한 번만 누르는 경우만 고려 하면 된다. -> 그 이상 누르는 건 최소값이 될 수없다.
# 스위치를 누르는 순서는 중요치 않다.
# 위의 모양에서 윗방향 전구가 확실히 꺼진 상태로 고정이 되려면 좌표가 (i, j)라고 할 때, (i+1, j)에서 스위치를 눌러 꺼지거나 (i, j)가 꺼진상태여야 한다.
# 즉, (i+1, j)의 스위치를 (i, j)의 불이 켜져있다면 누르고 꺼져있다면 누르지 않아야 한다.
# 자신 보다 바로 위의 요소가 없는 첫째 줄의 경우 모든 경우의 수를 구해봐야 한다.
dx=[-1,0,0,1,0]
dy=[0,-1,0,0,1]
board=[[0 for _ in range(10)] for _ in range(10)]
for i in range(10):
    inp=input().rstrip()
    for j in range(len(inp)):
        if inp[j]=='O':
            board[i][j]=1

def switch(b, x, y):
    for i in range(5):
        xx=x+dx[i]
        yy=y+dy[i]
        if 0<=xx<10 and 0<=yy<10:
            b[xx][yy] = (b[xx][yy]+1)%2

num=[0, 1]
res=101
for c in product(num, repeat=10):
    tmp_board=[board[i][:] for i in range(10)]
    cnt=0
    for j in range(10):
        if c[j]==1:
            switch(tmp_board, 0, j)
            cnt+=1
    for i in range(1, 10):
        for j in range(10):
            if tmp_board[i-1][j]:
                switch(tmp_board, i, j)
                cnt+=1
    if sum(tmp_board[9])==0: # 앞에까지는 다 끄면서 내려왔으므로 마지막줄만 검사
       res=min(res, cnt)
print(res)