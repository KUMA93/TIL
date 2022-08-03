import sys
from collections import deque
input=sys.stdin.readline

# 1 2 3 4 5 6 7
# 3 6 2 7 5 1 4

n, k=map(int, input().split())
dq=deque(range(1, n+1))
cnt=0
res=[]
print('<', end='')
while dq:
    cnt+=1
    if cnt==k:
        print(dq.popleft(), end='')
        cnt=0
        if dq:
            print(', ', end='')
    else:
        dq.append(dq.popleft())
print('>')