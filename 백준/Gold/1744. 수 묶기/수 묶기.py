import sys
input=sys.stdin.readline

n=int(input()) # 1<=n<=50
# 요소가 음수면 묶지 않아야 하고 큰수끼리 묶으면 값이 더 커진다. 묶는 것은 두개의 수를 대상으로 가능하고 모든 수는 한번만 묶을 수 있다.
# 음수 * 음수  //  음수 + 양수  //  양수 * 양수
# 0 * 음수  //  0 + 양수
# 1 + 양수  //  1 + 음수
negativeNum=[]
positiveNum=[]
cnt=0
for i in range(n):
    num=int(input())
    if num<=0:
        negativeNum.append(num)
    else:
        positiveNum.append(num)
     # 각 요소는 -1000이상 1000이하
positiveNum.sort()
negativeNum.sort(reverse=True)
res=0

while len(positiveNum)>=2:
    x=positiveNum.pop()
    y=positiveNum.pop()

    if x==1 or y==1:
        res+=x+y
    else:
        res+=x*y
if positiveNum:
    res+=positiveNum.pop()

while len(negativeNum)>=2:
    x=negativeNum.pop()
    y=negativeNum.pop()

    res+=x*y
if negativeNum:
    res+=negativeNum.pop()

print(res)