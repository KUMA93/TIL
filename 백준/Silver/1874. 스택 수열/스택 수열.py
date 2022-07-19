import sys
input=sys.stdin.readline

n=int(input())
stack=[]
order=[]
cnt=0
flag=True
for i in range(n):
    tmp=int(input())
    while cnt<tmp:
        cnt+=1
        stack.append(cnt)
        order.append('+')
    if stack[-1]==tmp:
        stack.pop()
        order.append('-')
    else:
        flag=False
        break
if flag==False:
    print('NO')
else:
    for x in order:
        print(x)