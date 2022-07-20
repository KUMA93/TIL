import sys
from collections import deque
input=sys.stdin.readline

t=int(input())
for i in range(t):
    p=input().rstrip()
    n=int(input())
    tmp=input().rstrip()
    dq=deque()
    flag=0 # reverse 시간 초과 해결책
    cnt=0
    for i in range(len(tmp)):
        if cnt>0:
            cnt-=1
            continue
        if tmp[i].isdigit():
            j=i+1
            num=''
            num+=tmp[i]
            while j<len(tmp) and tmp[j].isdigit():
                num+=tmp[j]
                cnt+=1
                j+=1
            dq.append(int(num))

    for x in p:
        if x=='R':
            flag+=1
        elif x=='D':
            if dq:
                if flag%2==0:
                    dq.popleft()
                else:
                    dq.pop()
            else:
                print('error')
                break
    else:
        dq = list(dq)
        if flag%2==0:
            print('[', end='')
            for x in range(len(dq)):
                print(dq[x], end='')
                if x!=len(dq)-1:
                    print(',', end='')
            print(']')
        else:
            dq.reverse()
            print('[', end='')
            for x in range(len(dq)):
                print(dq[x], end='')
                if x != len(dq) - 1:
                    print(',', end='')
            print(']')
