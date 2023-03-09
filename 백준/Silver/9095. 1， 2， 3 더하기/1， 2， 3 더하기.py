import sys
input = sys.stdin.readline

# n은 양수이며 11보다 작다

dp = [0]*12
dp[1] = 1 # 1
dp[2] = 2 # 1 1 / 2
dp[3] = 4 # 1 1 1 / 2 1 / 1 2 / 3
# 4일 때 1 1 1 1 / 2 1 1 / 1 2 1 / 3 1 // 1 1 2 / 2 2 // 3~

for i in range(4, 12):
    dp[i] = dp[i-2] + dp[i-1] + dp[i-3]

for t in range(int(input())):
    print(dp[int(input())])