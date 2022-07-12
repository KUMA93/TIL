import sys

input=sys.stdin.readline
n=int(input()) #1<=n<=500
tri=[list(map(int, input().split())) for _ in range(n)] #0~9999

#외곽 먼저 채우기
for i in range(1, n):
    tri[i][0]=tri[i][0]+tri[i-1][0]
    tri[i][i]=tri[i][i]+tri[i-1][i-1]

#속 채우기
for i in range(2, n):
    for j in range(1, i):
        tri[i][j]=tri[i][j]+max(tri[i-1][j], tri[i-1][j-1])

print(max(tri[n-1]))