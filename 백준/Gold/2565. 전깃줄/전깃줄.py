import sys
input=sys.stdin.readline

n=int(input())
pole=[0]*501
dp=[1]*n
maxI=-1
for i in range(n):
    idx, con=map(int, input().split())
    pole[idx-1]=con
while 0 in pole:
    pole.remove(0)
# 증가 부분수열 찾기
for i in range(n):
    for j in range(i):
        if pole[i]>pole[j] and dp[i]<dp[j]+1:
            dp[i]=dp[j]+1

print(n-max(dp))