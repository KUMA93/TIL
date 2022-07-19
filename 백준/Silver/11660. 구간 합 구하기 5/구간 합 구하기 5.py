import sys
input=sys.stdin.readline

n, m=map(int, input().split())
board=[]
Sum=[[0]*(n+2) for _ in range(n+2)]
s=0
for i in range(n):
    tmp=list(map(int, input().split()))
    board.append(tmp)
    for j in range(n):
        s+=tmp[j]
        Sum[i+1][j+1]=s
        if j==n-1:
            Sum[i+2][0]=s
for i in range(m):
    x1, y1, x2, y2=map(int, input().split()) # x1 ≤ x2, y1 ≤ y2
    res=0
    for j in range(x1, x2+1):
        res+=Sum[j][y2]-Sum[j][y1-1]
    print(res)