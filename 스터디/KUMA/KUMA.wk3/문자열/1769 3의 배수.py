import sys
sys.stdin=open("input.txt", "rt")

input=sys.stdin.readline

x=list(map(int, input().strip())) # 큰 자연수
cnt=0
while x:
    if len(x)==1:
        x=x[0]
        break
    else:
        x=sum(x)
        x=list(map(int, str(x)))
        cnt+=1

if x%3==0:
    print(cnt)
    print('YES')
else:
    print(cnt)
    print('NO')