import sys
input = sys.stdin.readline

# X <= max - min
N, L, R, X = map(int, input().split())
num = list(map(int, input().split()))
cnt = 0

for subset in range(1 << N):
    res = []
    score = []
    scoreSum = 0
    gap = 0
    for i in range(N):
        if subset & (1 << i):
            res.append(i)
    for x in res:
        scoreSum += num[x]
        score.append(num[x])

    if not L <= scoreSum <= R:
        continue

    if max(score) - min(score) >= X:
        cnt += 1

print(cnt)