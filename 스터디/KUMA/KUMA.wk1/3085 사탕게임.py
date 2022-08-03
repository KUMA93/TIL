import sys
sys.stdin=open("input.txt", "rt")

n=int(input())
board=[list(input()) for _ in range(n)]
dx=[-1, 0, 1, 0]
dy=[0, -1, 0, 1] #상좌하우

def checkCol(x, y, k):
    cnt=1
    i, j=1, 1
    while True:
        if 0<=x+i<n and board[x+i][y]==k:
            cnt+=1
            i+=1
        else:
            break
    while True:
        if 0<=x-j<n and board[x-j][y]==k:
            cnt+=1
            j+=1
        else:
            break
    return cnt

def checkRow(x, y, k):
    cnt=1
    i, j=1, 1
    while True:
        if 0<=y+i<n and board[x][y+i]==k:
            cnt+=1
            i+=1
        else:
            break
    while True:
        if 0<=y-j<n and board[x][y-j]==k:
            cnt+=1
            j+=1
        else:
            break
    return cnt
maxC=0
for i in range(n):
    for j in range(n):
        maxC=max(maxC, checkRow(i, j, board[i][j]), checkCol(i, j, board[i][j]))

for x in range(n):
    for y in range(n):
        for i in range(4):
            xx=x+dx[i]
            yy=y+dy[i]
            if 0<=xx<n and 0<=yy<n and board[xx][yy]!=board[x][y]:
                board[xx][yy], board[x][y]=board[x][y], board[xx][yy]
                maxC = max(maxC, checkCol(x, y, board[x][y]), checkRow(x, y, board[x][y]))
                board[xx][yy], board[x][y]=board[x][y], board[xx][yy]
print(maxC)

#처음 작성 했던 코드의 마지막 부분, dx, dy의 위상 값에 따라서 행, 열을 둘중 하나만 체크하게 해서 리소스를 아끼려고 짠건데
#실패하는 이유를 모르겠음.. 위의 코드로 변경할 때 checkCol함수와 checkRow함수를 합쳐서 하나의 함수로 만들고
#매개변수도 x, y, k가 아닌 x, y로만 두는걸로 바꿔야 깔끔한데 그거까지 시간적 여유가 안나서 못함..
for x in range(n):
    for y in range(n):
        for i in range(4):
            xx=x+dx[i]
            yy=y+dy[i]
            if 0<=xx<n and 0<=yy<n and board[xx][yy]!=board[x][y]:
                if i==1 or i==3:
                    maxC=max(maxC, checkCol(x, y, board[xx][yy]))
                else:
                    maxC=max(maxC, checkRow(x, y, board[xx][yy]))
print(maxC)