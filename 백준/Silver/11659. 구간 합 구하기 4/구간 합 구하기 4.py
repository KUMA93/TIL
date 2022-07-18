import sys
input=sys.stdin.readline

n, m=map(int, input().split())
num=list(map(int, input().split()))
tmp=0
Sum=[0]
for x in num:
    tmp+=x
    Sum.append(tmp)

for t in range(m):
    i, j=map(int, input().split())
    print(Sum[j]-Sum[i-1])