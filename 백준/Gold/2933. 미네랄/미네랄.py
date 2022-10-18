import sys
from collections import deque
input = sys.stdin.readline

r, c = map(int, input().split())
mineral = [list(input().rstrip()) for _ in range(r)]
n = int(input())
h = list(map(lambda x:r-int(x), input().split()))

dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]

def checkDist(fallList, ch):
    fallDist, flag = 1, 0
    while True:
        for x, y in fallList:
            if x+fallDist==r-1:
                flag=1
                break
            if mineral[x+fallDist+1][y]=='x' and ch[x+fallDist+1][y]:
                flag=1
                break
        if flag:
            break
        fallDist+=1
    return fallDist

def checkLand():
    ch = [[0]*c for _ in range(r)]

    for y in range(c):
        if mineral[r-1][y]=='x' and not ch[r-1][y]:
            ch[r-1][y]=1
            dq=deque()
            dq.append((r-1, y))
            while dq:
                x, y = dq.popleft()
                for i in range(4):
                    xx = x+dx[i]
                    yy = y+dy[i]
                    if 0<=xx<r and 0<=yy<c and mineral[xx][yy]=='x' and not ch[xx][yy]:
                        ch[xx][yy]=1
                        dq.append((xx, yy))
    return ch

def destroyMineral(x, y):
    ch = checkLand()
    before = []
    fallList = []

    for i in range(4):
        xx = x+dx[i]
        yy = y+dy[i]
        if 0<=xx<r and 0<=yy<c and mineral[xx][yy]=='x' and not ch[xx][yy]:
            dq=deque()
            dq.append((xx, yy))
            ch[xx][yy]=2
            before.append((xx, yy))
            mineral[xx][yy]='.'

            while dq:
                a, b = dq.popleft()
                if mineral[a+1][b]=='.':
                    fallList.append((a, b))
                for j in range(4):
                    aa = a+dx[j]
                    bb = b+dy[j]
                    if 0<=aa<r and 0<=bb<c and mineral[aa][bb]=='x' and not ch[aa][bb]:
                        ch[aa][bb]=2
                        dq.append((aa, bb))
                        before.append((aa, bb))
                        mineral[aa][bb]='.'
    if fallList:
        fallDist=checkDist(fallList, ch)
        for n, m in before:
            mineral[n+fallDist][m]='x'

for i in range(n):
    if i%2==0:
        for y in range(c):
            if mineral[h[i]][y]=='x':
                mineral[h[i]][y] = '.'
                destroyMineral(h[i], y)
                break
    else:
        for y in range(c-1, -1, -1):
            if mineral[h[i]][y]=='x':
                mineral[h[i]][y] = '.'
                destroyMineral(h[i], y)
                break

for x in mineral:
    for y in x:
        print(y, end='')
    print()
