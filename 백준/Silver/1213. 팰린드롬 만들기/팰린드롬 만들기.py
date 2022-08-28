import sys
input=sys.stdin.readline
from collections import deque

alpha = [0] * 26
name = input().rstrip()
Ord=0
for x in name:
    alpha[ord(x)-65] += 1
size=sum(alpha)
if size%2==0:
    for x in range(26):
        if alpha[x]%2!=0:
            Ord += 1
    if Ord>0:
        print("I'm Sorry Hansoo")
    else:
        res=deque()
        for x in range(25, -1, -1):
            if alpha[x]>0:
                y = chr(x+65)
                for _ in range(alpha[x]//2):
                    res.appendleft(y)
                    res.append(y)
        for x in res:
            print(x, end='')
else:
    for x in range(26):
        if alpha[x]%2!=0:
            Ord += 1
            ordAlpha=x
    if Ord>1:
        print("I'm Sorry Hansoo")
    else:
        res=deque()
        ordAlpha=chr(ordAlpha+65)
        res.append(ordAlpha)
        for x in range(25, -1, -1):
            if alpha[x] > 0:
                y = chr(x + 65)
                for _ in range(alpha[x] // 2):
                    res.appendleft(y)
                    res.append(y)
        for x in res:
            print(x, end='')