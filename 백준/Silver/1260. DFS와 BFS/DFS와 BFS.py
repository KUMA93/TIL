import sys
from collections import deque
input = sys.stdin.readline

n, m, v = map(int, input().split())
graph = [[]*(n+1) for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

ch = [0]*(n+1)
def dfs(v):
    ch[v] = 1
    print(v, end=' ')
    for i in graph[v]:
        if not ch[i]:
            dfs(i)

dfs(v)
print()

ch = [0]*(n+1)
def bfs(v):
    dq = deque()
    dq.append(v)
    ch[v] = 1
    while dq:
        v = dq.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not ch[i]:
                dq.append(i)
                ch[i] = 1

bfs(v)