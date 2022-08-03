import sys

def checkRC(x, y, k):
    for i in range(9):
        if board[x][i]==k:
            return False
        if board[i][y]==k:
            return False
    return True

def checkSq(x, y, k):
    x//=3
    y//=3
    for a in range(x*3, (x+1)*3):
        for b in range(y*3, (y+1)*3):
            if board[a][b]==k:
                return False
    return True

state=False

def DFS(Lv):
    global state
    if state:
        return
    if Lv==len(zero):
        for row in board:
            print(*row)
        state=True
        exit(0)
    else:
        (i, j)=zero[Lv]

        for k in range(1, 10):
            if checkRC(i, j, k) and checkSq(i, j, k):
                board[i][j]=k
                DFS(Lv+1)
                board[i][j]=0

board=[list(map(int, sys.stdin.readline().split())) for _ in range(9)]
zero=[(i, j) for i in range(9) for j in range(9) if board[i][j]==0]
DFS(0)