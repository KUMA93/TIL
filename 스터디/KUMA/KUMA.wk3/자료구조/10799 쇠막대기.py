import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline
from collections import deque

# () 레이저
# (막대기 시작
# )막대기 끝
# 1. '('일 때 다음 요소 '('이면 막대 ')'이면 레이저
# 2. '(''(' 에서 막대기 카운팅+1 ')'에서 막대기 카운팅-1
# 3. '('')' 에서 총 막대기 수+= 현재 막대기 수
# cnt 현재 막대기 수
arr=deque(input().strip())
Sum=0
cnt=0
while arr:
    now=arr.popleft()
    if now=='(':
        tmp=arr.popleft()
        if tmp==')':
            Sum+=cnt
        else:
            cnt+=1
            arr.appendleft(tmp)
    else:
        Sum+=1
        cnt-=1

print(Sum)