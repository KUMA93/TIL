import sys
input=sys.stdin.readline

n=int(input()) ## 500000이하
tower=list(map(int, input().split()))
stack=[]
res=[0]*n

for i in range(n):
    std=tower[i]
    while stack and tower[stack[-1]] < std:
        stack.pop()
    if stack:
        res[i]=stack[-1]+1
    stack.append(i)

print(*res)