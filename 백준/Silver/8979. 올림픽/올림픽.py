import sys
input=sys.stdin.readline

n, k=map(int, input().split())

# 람다 정렬로는 애초에 n이 500까지 가게 되면 500*500의 정보량을 정렬해야하니 복잡도가 높다. 다른 방식으로 풀어봐야 한다.
score=[]
for i in range(n):
    score.append(list(map(int, input().split())))
score.sort(key=lambda x: (-x[1], -x[2], -x[3]))

for i in range(n):
    if score[i][0]==k:
        idx=i
for i in range(n):
    if score[i][1:]==score[idx][1:]:
        print(i+1)
        break