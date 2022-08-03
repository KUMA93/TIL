import sys
input=sys.stdin.readline

n, k=map(int, input().split())
num=list(map(int, input().split()))
size=0
Sum=[]
tmp=0
for i in range(n):
    size+=1
    tmp+=num[i]
    if size==k:
        size-=1
        Sum.append(tmp)
        tmp-=num[i-size]
print(max(Sum))