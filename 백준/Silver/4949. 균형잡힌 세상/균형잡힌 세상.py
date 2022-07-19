import sys
input=sys.stdin.readline

while True:
    stack=[]
    stc=input().rstrip()
    flag=True
    if stc=='.':
        break
    for x in stc:
        if x=='(' or x=='[':
            stack.append(x)
        elif x==')':
            if not stack or stack[-1]=='[':
                flag=False
                break
            elif stack[-1]=='(':
                stack.pop()
        elif x == ']':
            if not stack or stack[-1] == '(':
                flag=False
                break
            elif stack[-1] == '[':
                stack.pop()
    if stack:
        print('no')
    else:
        if flag==True:
            print('yes')
        else:
            print('no')