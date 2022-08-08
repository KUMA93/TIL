import sys
input=sys.stdin.readline

n, k=map(int, input().split())
scr=list(map(int, input().split()))
scr.sort()
for i in range(k):
    if i==k-1:
        print(scr.pop())
    else:
        scr.pop()
