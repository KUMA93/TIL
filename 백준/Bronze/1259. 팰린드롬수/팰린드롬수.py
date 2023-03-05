import sys
input = sys.stdin.readline
from collections import deque

while True:
    cur = input().strip()

    if cur == '0':
        break
    dq = deque()
    for x in cur:
        dq.append(x)
    size = len(dq) // 2
    flag = True

    for i in range(size):
        left = dq.popleft()
        right = dq.pop()

        if left != right:
            flag = False
            break

    print("yes" if flag else "no")