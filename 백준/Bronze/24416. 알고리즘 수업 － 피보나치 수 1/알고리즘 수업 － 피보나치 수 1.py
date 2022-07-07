import sys
input=sys.stdin.readline

n=int(input())
cnt_rec, cnt_dy=0, 0
def fib_rec(x):
    global cnt_rec
    if x==1 or x==2:
        cnt_rec+=1
        return 1
    else:
        return (fib_rec(x-1)+fib_rec(x-2))

dy=[0]*(n+1)
dy[1], dy[2]=1, 1
for i in range(3, n+1):
    dy[i]=dy[i-1]+dy[i-2]
    cnt_dy+=1

fib_rec(n)
print(cnt_rec)
print(cnt_dy)