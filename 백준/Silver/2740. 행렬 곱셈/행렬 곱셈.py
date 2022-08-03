import sys
input=sys.stdin.readline

n, m = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]
m, k = map(int, input().split())
B = [list(map(int, input().split())) for _ in range(m)]
res=[[0]*k for _ in range(n)]

for i in range(n):
    for j in range(k):
        for x in range(m):
            res[i][j]+=A[i][x]*B[x][j]

for x in res:
    for y in x:
        print(y, end=' ')
    print()