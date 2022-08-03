import sys
from collections import deque
input=sys.stdin.readline

# 중요도에 따라 인쇄할지 뒤로 미룰지 정한다

t=int(input())
for _ in range(t):
    n, m=map(int, input().split()) #문서의 개수 n, 타겟인 문서 인덱스 m
    dq=deque(map(list, input().split()))
    for i in range(n):
        dq[i][0]=int(dq[i][0])
        dq[i].append(i)
    cnt=0
    while dq:
        now=dq.popleft()
        if all(now[0]>=dq[i][0] for i in range(len(dq))):
            cnt+=1
            if now[1]==m:
                print(cnt)
                break
        else:
            dq.append(now)
