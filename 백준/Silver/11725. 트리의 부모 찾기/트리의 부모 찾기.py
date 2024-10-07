import sys
input = sys.stdin.readline
from collections import deque
#    1
#   4  6
#  2 7 3
#      5
# 루트가 1이니 다 입력 받고 1부터 시작해서 각 노드와 연결된 자식 노드를 탐색

n = int(input())
relation = list([] for _ in range(n+1))
parent = [0]*(n+1)

for _ in range(n-1):
    node1, node2 = map(int, input().split())
    relation[node1].append(node2)
    relation[node2].append(node1)

def bfs(cur):
    dq = deque()
    dq.append(cur)
    while dq:
        cur = dq.pop()
        for i in relation[cur]:
            if not parent[i]:
                dq.append(i)
                parent[i] = cur

bfs(1)

for i in range(2, n+1):
    print(parent[i])