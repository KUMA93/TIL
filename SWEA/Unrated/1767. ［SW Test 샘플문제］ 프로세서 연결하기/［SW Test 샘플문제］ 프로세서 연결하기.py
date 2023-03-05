
# 최대한 많은 Core에 전원을 연결, 여러 방법이 있을 경우, 전선 길이의 합이 최소가 되는 값
# 7 ≤  N ≤ 12, core 1 ~ 12
# 전원이 연결되지 않는 core 존재 가능

dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]

def connectPower(idx, powered, length):
    global minLength, maxCore

    if idx == len(coreList):
        if powered > maxCore:
            maxCore = powered
            minLength = length
        elif powered == maxCore:
            minLength = min(minLength, length)
        return

    x, y = coreList[idx]

    for i in range(4):
        gl = getLength(x, y, i)
        if gl == -1:
            if len(coreList) - idx + powered < maxCore:
                return
            connectPower(idx + 1, powered, length)
        else:
            connect(x, y, gl, i, 'c')
            connectPower(idx + 1, powered + 1, length + gl)
            connect(x, y, gl, i, 'd')

def getLength(x, y, d):
    nx = x
    ny = y
    length = 0
    while True:
        nx += dx[d]
        ny += dy[d]

        if 0 <= nx < N and 0 <= ny < N:
            if board[nx][ny] == 1:
                return -1
            else:
                length += 1
        else:
            return length

def connect(x, y, l, d, m):
    nx = x
    ny = y
    for _ in range(l):
        nx += dx[d]
        ny += dy[d]

        if m == 'c':
            board[nx][ny] = 1
        else:
            board[nx][ny] = 0

T = int(input())

for t in range(1, T + 1):
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    minLength = 2147000000
    maxCore = 0
    coreList = []

    for x in range(N):
        for y in range(N):
            if board[x][y] == 1:
                if x == 0 or x == N-1 or y == 0 or y == N-1: continue
                coreList.append((x, y))

    connectPower(0, 0, 0)
    print("#", end="")
    print(t, end=" ")
    print(minLength)