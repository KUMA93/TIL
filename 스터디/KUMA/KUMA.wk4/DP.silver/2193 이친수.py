import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

# 0으로 시작하지 않고 - 1로 시작해야 하고
# 1이 연속으로 나타나지 않는 이진수 - 10까진 고정 시작

n=int(input())
dp=[0]*(n+1)
dp[1]=1
if n>1:
    dp[2]=1
# 1
# 10
# 100 101
# 1000 1001 / 1010
# 10000 10001 / 10010 / 10100 10101
for i in range(3, n+1):
    dp[i]=dp[i-2]+dp[i-1]
print(dp[-1])