import sys
from collections import deque
input=sys.stdin.readline

n=int(input()) #2<=n<=100
board=[]
maxH=-2147000000
minH=2147000000
for i in range(n):
    tmp=list(map(int,input().split()))
    for j in range(n):
        maxH=max(maxH, tmp[j])
    board.append(tmp)
dx=[-1,0,1,0]
dy=[0,-1,0,1]
#dfs 코드 - 재귀 한도 초과 떠서 한도 풀면 메모리 초과뜸 ㅠ bfs로 하는게 맞는듯
# def DFS(x, y, h): #높이가 h이상인 지점 i,j와 이어져 있는 h이상인 지점들을 모두 탐색한다
#     ch[x][y]=1
#     for i in range(4):
#         xx=x+dx[i]
#         yy=y+dy[i]
#         for j in range(n):
#             if 0<=xx<n and 0<=yy<n and board[xx][yy]>h and ch[xx][yy]==0:
#                 DFS(xx, yy, h)
#
# res=0
# for h in range(1, maxH):
#     cnt = 0
#     ch = [[0] * n for _ in range(n)]
#     for i in range(n):
#         for j in range(n):
#             if board[i][j]>h and ch[i][j]==0:
#                 cnt+=1
#                 DFS(i, j, h)
#     res=max(res, cnt)
#     if cnt==0: #카운트가 0인 순간 그 이상 탐색이 의미가 없다
#         break
#
# print(res)

#bfs 코드
dq=deque()
res=0
#계속 틀리길래 왜그런가 했더니 시작 범위를 1이 아닌 0으로 해야 맞는 처리가 됨.. 즉, 비가 안오는 경우를 고려해야함
for h in range(0, 100):
    cnt = 0
    ch = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if ch[i][j]==0 and board[i][j]>h:
                dq.append((i, j))
                ch[i][j] = 1
                while dq:
                    now = dq.popleft()
                    for k in range(4):
                        x = now[0] + dx[k]
                        y = now[1] + dy[k]
                        if 0 <= x < n and 0 <= y < n and ch[x][y] == 0 and board[x][y] > h:
                            dq.append((x, y))
                            ch[x][y] = 1
                cnt += 1
    if cnt==0:
        break
    res=max(res, cnt)
print(res)