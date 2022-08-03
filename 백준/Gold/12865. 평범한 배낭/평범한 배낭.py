import sys
input=sys.stdin.readline

n, k=map(int, input().split())
dp=[[0]*(k+1) for _ in range(n)] # 가방의 무게를 기준으로 dp를 짠다
lst=[]
for i in range(n):
    lst.append(list(map(int, input().split())))

for i in range(n):
    for j in range(k+1):
        w=lst[i][0]
        v=lst[i][1]
        if j>=lst[i][0]:
            dp[i][j]=max(v+dp[i-1][j-w], dp[i-1][j])
        else:
            dp[i][j]=dp[i-1][j]

print(max(map(max, dp)))