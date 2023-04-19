import sys
input = sys.stdin.readline
from copy import deepcopy

# 1~5 주사위
# 파란 화살표 지점 외에는 무조건 빨간 화살표
# 말 4개
# 턴 10개
# 말이 이동을 마치는 지점의 수가 점수에 추가
# 말 업기 X

# 게임판을 여러 종류의 1차원 배열로 ?
# 10, 20, 30 에만 추가 선택지를 주는 식?

graph = [[1], [2], [3], [4], [5], [6, 21], [7], [8], [9], [10], [11, 25], [12], [13], [14], [15], [16, 27], [17], [18], [19], [20], [32], [22], [23], [24], [30], [26], [24], [28], [29], [24], [31], [20], [32]]
score = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 13, 16, 19, 25, 22, 24, 28, 27, 26, 30, 35, 0]
horse = [0, 0, 0, 0]
dice = list(map(int, input().split()))
MAX = 0

def dfs(idx, res, horse, test):
    global MAX
    if idx >= 10:
        MAX = max(MAX, res)
        return
    for i in range(4):
        x = horse[i]
        if len(graph[x]) == 2:
            x = graph[x][1]
        else:
            x = graph[x][0]
        for j in range(1, dice[idx]):
            x = graph[x][0]
        if x == 32 or (x < 32 and x not in horse):
            save = horse[i]
            horse[i] = x
            test.append(x)
            dfs(idx + 1, res + score[x], horse, test)
            test.pop()
            horse[i] = save

dfs(0, 0, horse, [])
print(MAX)