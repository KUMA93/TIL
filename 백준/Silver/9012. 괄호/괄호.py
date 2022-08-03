import sys
input=sys.stdin.readline

t=int(input())
stack=[]
flag=[0]*t
for i in range(t):
    PS=input().rstrip()
    for x in PS:
        if x=='(':
            stack.append(x)
        else:
            if stack:
                stack.pop()
            else:
                flag[i]=-1
    if stack:
        print('NO')
    else:
        if flag[i]==0:
            print('YES')
        else:
            print('NO')
    stack.clear()
