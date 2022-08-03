import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n=int(input())
num=list(map(int, input().split()))
optr=list(map(int, input().split()))
# 숫자를 표시하는 a리스트와 연산자를 표시하는 b리스트를 받아와서 계산해주는 calc함수
def calc(a, b):
    tmp=a[0]
    for i in range(n-1):
        if b[i]==0:
            tmp+=a[i+1]
        elif b[i]==1:
            tmp-=a[i+1]
        elif b[i]==2:
            tmp*=a[i+1]
        else:
            # 문제에서 정의한대로 C++14의 기준에 따라 음수일 때는 양수로 만들고 몫을 취하고 다시 음수로 만듬
            if tmp<0:
                tmp=-(tmp)
                tmp//=a[i+1]
                tmp=-(tmp)
            else:
                tmp//=a[i+1]
    return tmp
order=[]
maxR=-2147000000
minR=2147000000
def DFS(Lv):
    global maxR, minR
    if Lv==n:
        maxR=max(maxR, calc(num, order))
        minR=min(minR, calc(num, order))
        return
    else:
        # order라는 리스트에 연산자를 넣는 순열을 구함
        for i in range(4):
            if optr[i]>0:
                optr[i]-=1
                order.append(i)
                DFS(Lv+1)
                optr[i]+=1
                order.pop()

DFS(1)
print(maxR)
print(minR)