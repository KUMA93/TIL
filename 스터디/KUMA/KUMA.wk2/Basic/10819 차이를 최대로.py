import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n=int(input()) # 3<=n<=8
arr=list(map(int, input().split())) # 정수들의 범위는 -100~100
ch=[0]*n
def getDiff(arr):
    Sum=0
    for i in range(n-1):
        Sum+=abs(arr[i]-arr[i+1])
    return Sum
res=[]
maxV=-2147000000
def DFS(Lv):
    global maxV
    if Lv==n:
        maxV=max(maxV, getDiff(res))
        return
    else:
        for i in range(n):
            if ch[i]==0:
                ch[i]=1
                res.append(arr[i])
                DFS(Lv+1)
                ch[i]=0
                res.pop()
DFS(0)
print(maxV)