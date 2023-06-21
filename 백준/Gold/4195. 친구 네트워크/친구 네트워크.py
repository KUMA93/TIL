import sys
input=sys.stdin.readline

t=int(input())

def findParent(x):
    if parent[x] != x:
        parent[x] = findParent(parent[x])
    return parent[x]

for i in range(t):
    f=int(input()) # 100000이하
    cnt={}
    parent={}
    for j in range(f):
        fr1, fr2 = input().split()
        if fr1 not in parent:
            parent[fr1]=fr1
            cnt[fr1]=1
        if fr2 not in parent:
            parent[fr2]=fr2
            cnt[fr2]=1
        a=findParent(fr1)
        b=findParent(fr2)
        if a!=b:
            parent[a] = b
            cnt[b] += cnt[a]
        print(cnt[b])