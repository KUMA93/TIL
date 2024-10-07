import sys
input = sys.stdin.readline
from collections import deque


# 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결
# 2 ≤ N ≤ 10

def checkAdj(point, ter):
    dq = deque()
    dq.append(point)
    visited[point] = True

    while(dq):
        cur = dq.pop()

        for i in adjList[cur]:
            if i in ter and not visited[i]:
                dq.append(i)
                visited[i] = True


N = int(input())
MIN = sys.maxsize
population = list(map(int, input().split()))
adjList = [[] for _ in range(N)]
for i in range(N):
    inp = list(map(int, input().split()))
    for j in range(1, inp[0] + 1):
        adjList[i].append(inp[j] - 1)

for subset in range(1, (1 << N) - 1):
    ter1 = []
    ter2 = []

    for i in range(N):
        if subset & (1 << i):
            ter1.append(i);
        else:
            ter2.append(i);

    visited = [False] * N
    cnt1, cnt2 = 0, 0
    sum1, sum2 = 0, 0
    for i in ter1:
        if not visited[i]:
            cnt1 += 1
            checkAdj(i, ter1)
        if cnt1 > 1:
            break
    if cnt1 == 1:
        for i in ter2:
            if not visited[i]:
                cnt2 += 1
                checkAdj(i, ter2)
            if cnt2 > 1:
                break
        if cnt2 == 1:
            for a in ter1:
                sum1 += population[a]
            for b in ter2:
                sum2 += population[b]
            MIN = min(MIN, abs(sum1 - sum2))

print(MIN if MIN != sys.maxsize else -1)