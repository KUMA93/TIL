import sys
input = sys.stdin.readline
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
dh = [1, -1]

M, N, H = map(int, input().split())
board = [[[0] * M for _ in range(N)] for _ in range(H)]
dq = deque()
for h in range(H):
    for n in range(N):
        board[h][n] = list(map(int, input().split()))

res = -1
# 다 익었는지 확인하는 함수
def checkValid():
    global res
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if board[h][i][j] == 0:
                    return False
                else:
                    res = max(res, board[h][i][j])
    return True


# 익힐 토마토를 구하는 함수
def getTomatoList():
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if board[h][i][j] == 1:
                    dq.append((h, i, j))

def bfs():
    while dq:
        h, x, y = dq.popleft()
        # 수평 방향
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < N and 0 <= ny < M and  board[h][nx][ny] == 0:
                board[h][nx][ny] = board[h][x][y] + 1
                dq.append((h, nx, ny))
        # 수직 방향
        for d in range(2):
            nh = h + dh[d]
            if 0 <= nh < H and board[nh][x][y] == 0:
                board[nh][x][y] = board[h][x][y] + 1
                dq.append((nh, x, y))

getTomatoList()
bfs()

if checkValid():
    print(res - 1)
else:
    print(-1)