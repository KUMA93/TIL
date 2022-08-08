import sys
input=sys.stdin.readline

n=int(input())
weight=list(map(int, input().split()))
weight.sort()
# 1 1 2 3 6 7 30
# 조합써서 해봤지만 시간 초과
res=0
for i in range(n):
    if res+1>=weight[i]:
        res+=weight[i]
    else:
        break
print(res+1)