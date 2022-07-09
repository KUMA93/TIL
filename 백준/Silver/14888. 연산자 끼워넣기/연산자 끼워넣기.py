import sys

n=int(input())
num=list(map(int, input().split()))
add, sub, mul, div=map(int, input().split())
maxR=-sys.maxsize-1
minR=sys.maxsize
def DFS(Lv, res):
    global add, sub, mul, div, maxR, minR
    if Lv==n-1:
        maxR=max(maxR, res)
        minR=min(minR, res)
        return
    else:
        if add>0:
            add-=1
            DFS(Lv+1, res+num[Lv+1])
            add+=1
        if sub > 0:
            sub -= 1
            DFS(Lv + 1, res - num[Lv+1])
            sub += 1
        if mul>0:
            mul-=1
            DFS(Lv+1, res*num[Lv+1])
            mul+=1
        if div>0:
            div-=1
            if res<0:
                DFS(Lv+1, -(-(res)//num[Lv+1]))
            else:
                DFS(Lv+1, res//num[Lv+1])
            div+=1
DFS(0, num[0])
print("{}\n{}".format(maxR,minR))