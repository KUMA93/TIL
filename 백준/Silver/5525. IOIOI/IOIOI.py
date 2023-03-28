import sys
input = sys.stdin.readline

# N+1 개의 I
# N개의 O
# 1 ≤ N ≤ 1,000,000, 2N+1 ≤ M ≤ 1,000,000

N = int(input())
size = 2*N + 1
M = int(input())
S = input().strip()
P = ''
cnt = 0

for i in range(size):
    if i % 2 == 0:
        P += 'I'
    else:
        P += 'O'

for i in range(M-size+1):
    if S[i] == 'I':
        tmp = S[i:i+size]
        if tmp == P:
            cnt += 1

print(cnt)
