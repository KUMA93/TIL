import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n=int(input())
numList=dict()
for i in range(n):
    tmp=int(input())
    if tmp in numList:
        numList[tmp]+=1
    else:
        numList[tmp]=1
maxC=0
for key, val in numList.items():
    if val>maxC:
        maxC=val
        maxKey=key
    elif val==maxC:
        maxKey=min(maxKey, key)
print(maxKey)