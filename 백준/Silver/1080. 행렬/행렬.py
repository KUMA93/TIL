import sys
input=sys.stdin.readline

#000 전체 상태 반전
#000 -> 9칸중 첫번째 칸을 기준으로 시행하면 된다
#000 -> 뒤집는 순서는 중요치 않다

n, m=map(int, input().split())
a, b=[], []
for k in range(2):
    for j in range(n):
        if k==0:
            a.append(list(map(int, input().rstrip())))
        else:
            b.append(list(map(int, input().rstrip())))
cnt=0
def flip(x, y):
    for i in range(x, x+3):
        for j in range(y, y+3):
            a[i][j]=1-a[i][j]

for i in range(n-2):
    for j in range(m-2):
        if a[i][j]!=b[i][j]:
            flip(i, j)
            cnt+=1
if a==b:
    print(cnt)
else:
    print(-1)
