import sys

input=sys.stdin.readline
n=int(input()) #2<=n<=1000
board=[list(map(int, input().split())) for _ in range(n)] #각 요소는 1000이하

#조합 구해서 풀어야될거 같은데 이것도 동적계획이라니 멘붕.. 이걸 어떻게 동적 계획으로 풀지
# 1 + min(2, 3)
# 2 + min(1, 3)
# 3 + min(1, 2) 를 매번 검사하고 저장하면 n이 1000일 때 시간초과가 안뜨나
for i in range(1, n):
    board[i][0]=min(board[i-1][1], board[i-1][2]) + board[i][0]
    board[i][1]=min(board[i-1][0], board[i-1][2]) + board[i][1]
    board[i][2]=min(board[i-1][0], board[i-1][1]) + board[i][2]
print(min(board[n-1][0], board[n-1][1], board[n-1][2]))
