import sys
input=sys.stdin.readline

t=int(input())
for i in range(t):
    n, m=map(int, input().split())
    dp=[0]*(m+1) # m에 따른 최대 가짓수
    dp[n]=1
    for i in range(n+1, m+1):
        dp[i]=dp[i-1]*i//(i-n)
    print(dp[-1])