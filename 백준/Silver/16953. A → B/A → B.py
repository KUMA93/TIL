import sys
input=sys.stdin.readline

# 2를 곱하거나 1을 수 오른쪽에 추가 // 왼쪽수 기준
# 2를 나누거나 1을 수 오른쪽에서 제거 // 오른쪽수 기준
a, b=map(int, input().split())
cnt=1
while b!=a:
    cnt+=1
    tmp=b
    if b%10==1:
        b//=10
    elif b%2==0:
        b//=2

    if tmp==b:
        print(-1)
        exit(0)
print(cnt)
