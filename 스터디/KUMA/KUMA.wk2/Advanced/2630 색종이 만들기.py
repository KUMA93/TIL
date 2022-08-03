import sys
input=sys.stdin.readline

n=int(input())
board=[list(map(int, input().split())) for _ in range(n)]
cnt=[0, 0]

def quadTree(x, y, n):
    ch=board[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if board[i][j]!=ch:
                ch=-1
                break
    if ch==-1:
        n//=2
        for i in range(2):
            for j in range(2):
                quadTree(x+(i*n), y+(j*n), n)
    else:
        cnt[ch]+=1
quadTree(0, 0, n)
for x in cnt:
    print(x)