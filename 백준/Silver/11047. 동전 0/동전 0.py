import sys
input=sys.stdin.readline

n, k=map(int, input().split()) # 1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000
coin=[]
for i in range(n):
    tmp=int(input())
    coin.append(tmp) # 1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수
    if tmp<=k:
        idx=i
i=0
cnt=0
while True:
    if k==0:
        break
    cnt+=k//coin[idx-i]
    k%=coin[idx-i]
    i+=1
print(cnt)