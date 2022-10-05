import sys

str = input().rstrip()
stack = []
res = ''
for x in str:
    if x.isalpha():
        res += x
    elif x=='(':
        stack.append(x)
    elif x==')':
        while stack and stack[-1]!='(':
            res += stack.pop()
        stack.pop()
    elif x=='+' or x=='-':
        while stack and stack[-1]!='(':
            res += stack.pop()
        stack.append(x)
    elif x=='*' or x=='/':
        while stack and (stack[-1]=='*' or stack[-1]=='/'):
            res += stack.pop()
        stack.append(x)
while stack:
    res += stack.pop()
print(res)