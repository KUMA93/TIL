n=int(input())
syn=[list(map(int, input().split())) for _ in range(n)]
minR=2147000000
teamA=[]
teamB=[]
def DFS(Lv):
    global minR
    if Lv==n//2:
        sumA=0
        sumB=0
        for i in range(0, n):
            if i not in teamA:
                teamB.append(i)
        for i in range(0, n//2-1):
            for j in range(i+1, n//2):
                sumA+=syn[teamA[i]][teamA[j]]+syn[teamA[j]][teamA[i]]
                sumB+=syn[teamB[i]][teamB[j]]+syn[teamB[j]][teamB[i]]
        minR=min(minR, abs(sumA-sumB))
        teamB.clear()
        return
    else:
        for i in range(n):
            if i in teamA:
                continue
            if len(teamA)>0 and teamA[len(teamA)-1]>i:
                continue
            teamA.append(i)
            DFS(Lv+1)
            teamA.pop()
DFS(0)
print(minR)