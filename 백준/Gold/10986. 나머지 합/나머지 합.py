import sys
input=sys.stdin.readline

n, m=map(int, input().split())
num=list(map(int, input().split()))
tmp=0
cnt=[0]*m
for i in range(n):
    tmp+=num[i]
    cnt[tmp%m]+=1
res=cnt[0]
for x in cnt:
    res+=x*(x-1)//2
print(res)