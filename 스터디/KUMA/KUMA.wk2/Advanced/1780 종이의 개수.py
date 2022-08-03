import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n=int(input())
board=[list(map(int, input().split())) for _ in range(n)]
cnt=[0, 0, 0]
def Check3(x, y, n):
    ch=board[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if board[i][j]!=ch:
                ch=2
                break
    if ch==0 or ch==1 or ch==-1:
        cnt[ch+1]+=1
    else:
        n//=3
        for i in range(3):
            for j in range(3):
                Check3(x+(i*n), y+(j*n), n)
Check3(0,0,n)
for x in cnt:
    print(x)