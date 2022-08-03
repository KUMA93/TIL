import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n, k=map(int, input().split())
coin=[0]
dp=[10001]*(k+1)# dp를 k원을 채우는 최소 동전 개수로 정의한다
dp[0]=0
for i in range(n):
    coin.append(int(input().rstrip()))
coin.sort() # 같은 가치의 동전이 여러번 주어질 수도 있다는데 일단 그냥하고 시간 초과나면 set로 제거 해줘야될 것 같음

for i in range(1, k+1):
    for j in range(1, n+1):
        if i<coin[j]:
            continue
        else:
            dp[i]=min(dp[i], dp[i-coin[j]]+1)
if dp[k]!=10001:
    print(dp[k])
else:
    print(-1)

# dp 확인용
print(dp)
