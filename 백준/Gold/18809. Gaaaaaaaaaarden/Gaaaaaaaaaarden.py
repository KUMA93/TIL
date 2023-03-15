import sys
input = sys.stdin.readline
from collections import deque

# 행의 개수와 열의 개수를 나타내는 N(2 ≤ N ≤ 50)과 M(2 ≤ M ≤ 50)
# 초록색 배양액의 개수 G(1 ≤ G ≤ 5)
# 빨간색 배양액의 개수 R(1 ≤ R ≤ 5)
# 0은 호수, 1은 배양액을 뿌릴 수 없는 땅, 2는 배양액을 뿌릴 수 있는 땅

N, M, G, R = map(int, input().split())
cand = []
select = []
board = [[] for _ in range(N)]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
res = 0
INF = sys.maxsize

def bfs(dq):
    visited = [[0] * M for _ in range(N)]
    for _ in range(len(dq)):
        x, y, c = dq.popleft()
        if c == 'G':
            visited[x][y] = 1
        elif c == 'R':
            visited[x][y] = -1
        dq.append((x, y, c))

    cnt = 0
    while dq:
        cx, cy, c = dq.popleft()

        if visited[cx][cy] == INF:
            continue

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if (board[nx][ny] == 1 or board[nx][ny] == 2) and visited[nx][ny] != INF and visited[nx][ny] == 0 :
                    if visited[nx][ny] == 0:
                        if c == 'G':
                            visited[nx][ny] = visited[cx][cy] + 1
                            dq.append((nx, ny, c))
                        elif c == 'R':
                            visited[nx][ny] = visited[cx][cy] - 1
                            dq.append((nx, ny, c))
                elif visited[nx][ny] * visited[cx][cy] < 0 and abs(visited[nx][ny]) == abs(visited[cx][cy]) + 1:
                    visited[nx][ny] = INF
                    cnt += 1
    # for x in visited:
    #     for y in x:
    #         print(y, end=' ')
    #     print()
    # print()
    return cnt

# 후보에서 부분집합을 구할 때 선택지를 3개로 한다.
def subset(cnt, g, r):
    global res
    if cnt == size:
        if g == G and r == R:
            dq = deque()
            for i in range(size):
                if select[i] != 'N':
                    dq.append((cand[i][0], cand[i][1], select[i]))
            res = max(res, bfs(dq))
        return
    else:
        if g < G:
            select.append('G')
            subset(cnt + 1, g + 1, r)
            select.pop()

        if r < R:
            select.append('R')
            subset(cnt + 1, g, r + 1)
            select.pop()

        select.append('N')
        subset(cnt + 1, g, r)
        select.pop()

for i in range(N):
    inp = list(map(int, input().split()))
    for j in range(len(inp)):
        if inp[j] == 2:
            cand.append((i, j))
    board[i] = inp

size = len(cand)

subset(0, 0, 0)
print(res)