import sys
input = sys.stdin.readline

# A대학 1~N
# B대학 1~M
# 팔 교차 X, 악수 못 하는 사람 생김
# 만족도 최대값

N, M, C = map(int, input().split())
char = [list(map(int, input().split())) for _ in range(C)]
A = list(map(lambda x: x-1, map(int, input().split())))
B = list(map(lambda x: x-1, map(int, input().split())))

# A대학 학생 i번째, B대학 학생 j번째까지 선택했을 때 기준으로 dp작성
dp = [[0]*(M+1) for _ in range(N+1)]
satisfy = [[0]*M for _ in range(N)]

# Ai와 Bj가 만났을 때 만족도
for i in range(N):
    for j in range(M):
        satisfy[i][j] = char[A[i]][B[j]]

for i in range(1, N+1):
    for j in range(1, M+1):
        dp[i][j] = max(dp[i-1][j-1] + satisfy[i-1][j-1], dp[i-1][j], dp[i][j-1])

print(dp[-1][-1])