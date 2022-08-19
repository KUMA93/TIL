import sys
from collections import deque
input=sys.stdin.readline

n, m = map(int, input().split()) # 2 ≤ N ≤ 10,000, 1 ≤ M ≤ 100,000
bridge=[[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split()) # 1 ≤ A, B ≤ N, 1 ≤ C ≤ 1,000,000,000, 서로 같은 두 섬 사이에 여러 개의 다리가 있을 수도 있다.
    bridge[a].append((b, c))
    bridge[b].append((a, c))
startIsland, endIsland = map(int, input().split())

def BFS(mid):
    dq=deque()
    dq.append(startIsland)
    ch[startIsland] = True
    while dq:
        now = dq.popleft()
        if now == endIsland:
            return True
        for nnow, ncost in bridge[now]:
            if not ch[nnow]:
                if mid <= ncost:
                    ch[nnow] = True
                    dq.append(nnow)
res=0
start, end = 1, 1000000000
while start <= end:
    ch = [0] * (n+1)
    mid = (start + end) // 2
    if BFS(mid):
        res = mid
        start = mid +1
    else:
        end = mid -1
print(res)