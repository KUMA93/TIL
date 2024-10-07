import sys
input = sys.stdin.readline
from collections import deque

# N : 2 ~ 100  ->  사람의 수
# M : 1 ~ 5000

def bfs(start):
    visited = [100]*(N+1)
    visited[start] = 0
    dq = deque()
    for x in relation[start]:
        dq.append((x, visited[start] + 1))

    while dq:
        dest, dt = dq.popleft()
        if visited[dest] > dt:
            visited[dest] = dt
            for x in relation[dest]:
                dq.append((x, dt+1))

    return sum(visited) - 100


N, M = map(int, input().split())
relation = [[] for _ in range(N+1)]

for _ in range(M):
    node1, node2 = map(int, input().split())
    relation[node1].append(node2)
    relation[node2].append(node1)

minVal = sys.maxsize
minIdx = -1
for i in range(1, N+1):
    cur = bfs(i)
    if minVal > cur:
        minVal = cur
        minIdx = i

print(minIdx)


