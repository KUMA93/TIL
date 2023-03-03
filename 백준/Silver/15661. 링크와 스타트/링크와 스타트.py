import sys
input = sys.stdin.readline

n = int(input())
status = [list(map(int, input().split())) for _ in range(n)]
minGap = sys.maxsize

def scoring(team):
    score = 0
    for player1 in team:
        for player2 in team:
            score += status[player1][player2] + status[player2][player1]
    return score

# teamA , teamB 나누기
for subset in range(1, (1 << n) - 1):
    teamA = []
    teamB = []
    for i in range(n):
        if subset & (1 << i):
            teamA.append(i)
        else:
            teamB.append(i)

    # 점수 산출
    sumA = scoring(teamA)
    sumB = scoring(teamB)
    minGap = min(minGap, abs(sumA - sumB))

print(minGap//2)