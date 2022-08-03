import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

# find, 슬라이싱으로 하는 방법 - 시간 초과 뜸 ㅠ 찾아보니 슬라이싱이 O(n) 이라 제거 할때마다 수행하는거라 O(n^2)이 됨

# S=input().strip()
# bomb=input().strip()
# size=len(bomb)
# while S.find(bomb)!=-1:
#     S=S[:S.find(bomb)]+S[S.find(bomb)+len(bomb):]
# if S:
#     print(S)
# else:
#     print('FRULA')

# S를 list로 해서 del로 제거하는 방안 - 리스트 생성도, join도 O(n)이다

# S=input().strip()
# bomb=input().strip()
# size=len(bomb)
# while S.find(bomb)!=-1:
#     idx=S.find(bomb)
#     S=list(S)
#     del S[idx:idx+size]
#     S=''.join(S)
# if S:
#     print(S)
# else:
#     print('FRULA')

# 스택으로 하나하나 비교하는 방법
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
