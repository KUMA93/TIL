import sys
from collections import deque
input=sys.stdin.readline

# 1번 popleft - 이번에 뽑아야 하는 수
# 2번 popleft, append cnt+=1
# 3번 pop, appendleft cnt+=1

# 1 2 3 4 5 6 7 8 9 10
# 2 3 4 5 6 7 8 9 10 1  cnt 1
# 3 4 5 6 7 8 9 10 1    2
# 10 1 3 4 5 6 7 8 9    cnt 3
# 9 10 1 3 4 5 6 7 8    cnt 4
# 10 1 3 4 5 6 7 8      9
# 1 3 4 5 6 7 8 10      cnt 5
# 3 4 5 6 7 8 10 1      cnt 6
# 4 5 6 7 8 10 1 3      cnt 7
# 5 6 7 8 10 1 3 4      cnt 8
# 6 7 8 10 1 3 4        5
n, m=map(int, input().split())
dq=deque(range(1, n+1))
tg=list(map(int, input().split()))
cnt=0
for t in range(m):
    if dq[0]==tg[t]:
        dq.popleft()
    else:
        if dq.index(tg[t])<=len(dq)//2:
            while dq[0]!=tg[t]:
                dq.append(dq.popleft())
                cnt+=1
            dq.popleft()
        else:
            while dq[0]!=tg[t]:
                dq.appendleft(dq.pop())
                cnt+=1
            dq.popleft()
print(cnt)
