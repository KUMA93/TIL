import sys
input = sys.stdin.readline

# 세로 N, 가로 M
# 1 ≤ M, N ≤ 500, 0 ≤ B ≤ 6.4 × 107
# 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. -> 2초
# 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. -> 1초

res = sys.maxsize
val = 0
N, M, B = map(int, input().split())
MIN = sys.maxsize
MAX = 0
board = [[] for _ in range(N)]

for i in range(N):
    tmp = list(map(int, input().split()))
    MIN = min(MIN, min(tmp))
    MAX = max(MAX, max(tmp))
    board[i] = tmp

for h in range(MIN, MAX+1):
    time = 0
    block = B
    for i in board:
        for j in i:
            size = abs(j - h)
            if j == h:
                continue
            elif j > h:
                block += size
                time += 2*size
            else:
                block -= size
                time += size

    if block >= 0 and res >= time:
        res = time
        val = h

print(res, val)