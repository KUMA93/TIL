import sys
input = sys.stdin.readline

INF = 987654321
N = int(input())
adj = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    for j in range(N):
        if adj[i][j] == 0:
            adj[i][j] = INF

for k in range(N):
    for i in range(N):
        for j in range(N):
            if(adj[i][j] > adj[i][k] + adj[k][j]):
                adj[i][j] = adj[i][k] + adj[k][j]

for x in adj:
    for y in x:
        if y == INF:
            print(0, end=' ')
        else:
            print(1, end=' ')
    print()