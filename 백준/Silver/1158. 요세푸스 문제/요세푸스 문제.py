import sys
from collections import deque
input=sys.stdin.readline

n, k = map(int, input().split())
dq=deque(range(1, n+1))
cnt=1

print('<', end='')
while dq:
    if cnt==k:
        print(dq.popleft(), end='')
        cnt=1
        if dq:
            print(', ', end='')
    else:
        dq.append(dq.popleft())
        cnt+=1
print('>')