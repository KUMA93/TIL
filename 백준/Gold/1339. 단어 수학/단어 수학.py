import sys
input=sys.stdin.readline

n=int(input())
lst=[]
Alpha=dict()
for i in range(n):
    S=input().rstrip()
    lst.append(S)
    size=len(S)
    for x in S:
        if x in Alpha:
            Alpha[x].append(10**(size-1))
            size-=1
        else:
            Alpha[x]=[10**(size-1)]
            size-=1
res=[]
for key, val in Alpha.items():
    res.append([key, sum(val)])
res.sort(key=lambda x: -x[1])
num=9
ans=0
for x in res:
    ans+=x[1]*num
    num-=1
print(ans)
