import sys
input = sys.stdin.readline

N = 10
paper = [0] * 5
res = sys.maxsize
board = [list(map(int, input().split())) for _ in range(N)]

def attach(x, y, s):
    for i in range(x, x+s+1):
        for j in range(y, y+s+1):
            board[i][j] = 0

def detach(x, y, s):
    for i in range(x, x+s+1):
        for j in range(y, y+s+1):
            board[i][j] = 1

def checkValid(x, y, s):
    for i in range(x, x+s+1):
        for j in range(y, y+s+1):
            if board[i][j] == 0:
                return False
    return True

def dfs(x, y, cnt):
    global res

    if x > 9:
        res = min(res, cnt)
        return
    if y > 9:
        dfs(x+1, 0, cnt)
        return
    if board[x][y] == 1:
        for s in range(5):
            if paper[s] == 5:
                continue
            if x + s > 9 or y + s > 9:
                continue
            if checkValid(x, y, s):
                attach(x, y, s)
                paper[s] += 1
                dfs(x, y+s+1, cnt+1)
                detach(x, y, s)
                paper[s] -= 1
    else:
        dfs(x, y+1, cnt)

dfs(0, 0, 0)
print(res if res != sys.maxsize else -1)