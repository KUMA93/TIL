import sys
input = sys.stdin.readline

# n 30이하 자연수, 추의 무게 500g이하
n = int(input())
weights = list(map(int, input().split()))

# 구슬 개수 m 7이하, 구슬 무게 40000g 이하
m = int(input())
beads = list(map(int, input().split()))

dp = [[False]*(40001) for _ in range(n)]
dp[0][weights[0]] = True
for i in range(1, n):
    dp[i][weights[i]] = True
    for j in range(1, len(dp[i-1])):
        if dp[i-1][j] == True:
            dp[i][j] = True;
            if j-weights[i] > 0:
                dp[i][j-weights[i]] = True
            if weights[i]-j > 0:
                dp[i][weights[i]-j] = True
            if j+weights[i] < len(dp[i]):
                dp[i][j+weights[i]] = True
for x in beads:
    if dp[-1][x] == True:
        print("Y ", end='')
    else:
        print("N ", end='')