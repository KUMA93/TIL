import sys
input = sys.stdin.readline

# N : 0 ~ 500,000
# M : 0 ~ 9

N = int(input())
M = int(input())
res = abs(N - 100)
tmp = list(map(int, input().split()))
broken = dict()
for i in range(10):
    broken[i] = 0
for i in range(M):
    broken[tmp[i]] = 1

for i in range(1000000):
    num = str(i)
    for j in range(len(num)):
        if broken[int(num[j])] == 1:
            break
        elif j == len(num) - 1:
            res = min(res, abs(i - N) + len(num))

print(res)
