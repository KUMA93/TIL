import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n=int(input())
P=list(map(int, input().split()))

dp=[0]*(n+1) # 카드를 n개를 갖기 위해 지불해야 하는 최대금액
for i in range(2, n+1):
    dp[i]=P[i-1]
    for j in range(1, i):
        dp[i]=max(dp[i], dp[i-j]+dp[j])
        if i%j==0:
            dp[i]=max(dp[i], i//j*dp[j])
print(dp[-1])