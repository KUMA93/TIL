import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n, k=map(int, input().split())
score=[]
for i in range(n):
    score.append(list(map(int, input().split())))
score.sort(key=lambda x: (-x[1], -x[2], -x[3]))

for i in range(n):
    score[i].append(i+1)
for i in range(1, n):
    if score[i][1:4]==score[i-1][1:4]:
        score[i][4]=score[i-1][4]
for i in range(n):
    if score[i][0]==k:
        print(score[i][4])