import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

# 스택 코드

S=input().strip()
# '()'를 '2'로 '[]'를 '3'으로 치환
# 숫자끼리 만나면 덧셈, 숫자를 소괄호가 감싸면 *2, 대괄호가 감싸면 *3
# tmp S
S=S.replace('()', '2')
S=S.replace('[]', '3')
stack=[]
num=[]

for x in S:
    if x==')':
        if not stack:
            print(0)
            sys.exit(0)
        while stack:
            now=stack.pop()
            if now=='(':
                stack.append(str(sum(num)*2))
                num.clear()
                break
            elif now.isdecimal():
                num.append(int(now))
            else:
                print(0)
                sys.exit(0)
    elif x==']':
        if not stack:
            print(0)
            sys.exit(0)
        while stack:
            now=stack.pop()
            if now=='[':
                stack.append(str(sum(num)*3))
                num.clear()
                break
            elif now.isdecimal():
                num.append(int(now))
            else:
                print(0)
                sys.exit(0)
    else:
        stack.append(x)
for i in range(len(stack)):
    if stack[i].isdecimal():
        stack[i]=int(stack[i])
    else:
        print(0)
        sys.exit(0)
print(sum(stack))
