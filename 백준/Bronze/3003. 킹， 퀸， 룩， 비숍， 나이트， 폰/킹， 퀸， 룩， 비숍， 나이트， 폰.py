import sys
input=sys.stdin.readline

tmp=list(map(int, input().split()))
target=[1, 1, 2, 2, 2, 8]
res=[]
for i in range(6):
    res.append(target[i]-tmp[i])
print(*res)