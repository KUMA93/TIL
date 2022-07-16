import sys
input=sys.stdin.readline
S=input().strip()
bomb=list(input().strip())
size=len(bomb)
stack=[]
tmp=[]
if len(S)<size:
    print(S)
elif len(S)==size:
    if S==''.join(bomb):
        print('FRULA')
else:
    bomb.reverse()
    for x in S:
        if x==bomb[0]:
            tmp.append(x)
            if len(stack)>=size-1:
                for i in range(size-1):
                    tmp.append(stack.pop())
            if tmp==bomb:
                tmp.clear()
            else:
                while tmp:
                    stack.append(tmp.pop())
        else:
            stack.append(x)
    if stack:
        for x in stack:
            print(x, end='')
    else:
        print('FRULA')
