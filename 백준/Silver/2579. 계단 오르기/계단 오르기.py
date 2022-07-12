import sys

input=sys.stdin.readline
n=int(input()) #1<=n<=300
stair=[] # 10000이하
dp=[0]*(n+1)
for i in range(n):
    stair.append(int(input().strip()))
#연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다. << 이 규칙이 난감하다
stair.insert(0, 0)
dp[1]=stair[1]
if n>=2:
    dp[2]=max(stair[0]+stair[2], stair[1]+stair[2])

for i in range(3, n+1):
    dp[i]=stair[i]+max(dp[i-2], dp[i-3]+stair[i-1])

print(dp[-1])

