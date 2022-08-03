import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

m, n=map(int, input().split())
board=[list(map(int, input().split())) for _ in range(m)]
ch=[[-1]*n for _ in range(m)] # 방문 여부 확인

#확인용
# for x in board:
#     print(x)
# print()
# for x in ch:
#     print(x)

dx=[0, 1, 0, -1]
dy=[1, 0, -1, 0]
def DFS(x, y):
    if x==m-1 and y==n-1:
        return 1
    else:
        if ch[x][y]==-1:
            ch[x][y]=0
            for i in range(4):
                xx=x+dx[i]
                yy=y+dy[i]
                if 0<=xx<m and 0<=yy<n and board[x][y]>board[xx][yy]:
                    ch[x][y] += DFS(xx, yy)
    return ch[x][y]

print(DFS(0, 0))