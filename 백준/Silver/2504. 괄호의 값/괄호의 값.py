import sys
input = sys.stdin.readline

# () 2
# [] 3

inp = input().strip()
stack = []
res = 0
tmp = 1

for x in range(len(inp)):
    if inp[x] == '(':
        stack.append(inp[x])
        tmp *= 2
    elif inp[x] == '[':
        stack.append(inp[x])
        tmp *= 3
    elif inp[x] == ')':
        if not stack or stack[-1] == '[':
            res = 0
            break
        if inp[x-1] == '(':
            res += tmp
        stack.pop()
        tmp //= 2
    elif inp[x] == ']':
        if not stack or stack[-1] == '(':
            res = 0
            break
        if inp[x-1] == '[':
            res += tmp
        stack.pop()
        tmp //= 3

if stack:
    print(0)
else:
    print(res)