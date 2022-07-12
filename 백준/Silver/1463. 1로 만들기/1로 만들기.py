import sys

input=sys.stdin.readline

# X가 3으로 나누어 떨어지면, 3으로 나눈다.
# X가 2로 나누어 떨어지면, 2로 나눈다.
# 1을 뺀다.

n=int(input().strip())

dp=[0]*(n+1)
if n>=2:
    dp[2]=1
if n>=3:
    dp[3]=1

for i in range(4, n+1):
    if i%2==0 and i%3==0:
        dp[i]=min(dp[i//2]+1, dp[i//3]+1, dp[i-1]+1)
    elif i%2==0:
        dp[i]=min(dp[i//2]+1, dp[i-1]+1)
    elif i%3==0:
        dp[i]=min(dp[i//3]+1, dp[i-1]+1)
    else:
        dp[i]=dp[i-1]+1

print(dp[-1])