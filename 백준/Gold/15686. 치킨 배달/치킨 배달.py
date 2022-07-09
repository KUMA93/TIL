import sys
input=sys.stdin.readline

n, m=map(int, input().split()) # 2<=n<=50 1<=m<=13
board=[list(map(int, input().split())) for _ in range(n)]
hs=[]
ck=[]
res=2147000000
ch=[0]*m
for i in range(n):
    for j in range(n):
        if board[i][j]==1:
            hs.append((i, j))
        elif board[i][j]==2:
            ck.append((i, j))
def DFS(Lv, s):
    global res
    if Lv==m:
        Sum=0
        for i in range(len(hs)):
            x1=hs[i][0]
            y1=hs[i][1]
            dt=2147000000
            for x in ch:
                x2=ck[x][0]
                y2=ck[x][1]
                dt=min(dt, abs(x2-x1)+abs(y2-y1))
            Sum+=dt
        res=min(res, Sum)
    else:
        #s부터 ck 리스트 끝까지 돌며 인덱스 값을 ch에 저장한다
        for i in range(s, len(ck)):
            ch[Lv]=i
            DFS(Lv+1, i+1)
DFS(0, 0)
print(res)