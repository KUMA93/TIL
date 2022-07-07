import sys
from collections import deque
input=sys.stdin.readline
t=int(input())

# 시간 초과난 코드, 커서라는 별개의 포인터를 이용한 스택이었는데 insert가 O(n)이라서 O(n^2)이 된다. insert를 안쓰는 방법이 필요하다
# for i in range(t):
#     pw=[]
#     key=input()
#     cursor=0
#     for x in key:
#         if x.isalnum():
#             pw.insert(cursor, x)
#             cursor+=1
#         else:
#             if x=='<' and cursor>0:
#                 cursor-=1
#             elif x=='>' and cursor<len(pw):
#                 cursor+=1
#             elif x=='-' and len(pw)>0:
#                 pw.pop()
#     for x in pw:
#         print(x, end='')
#     print()

#커서를 중앙에 두고 커서 좌측 스택과 우측 데크를 따로 두어 시간복잡도를 O(n)으로 낮춘 방법
for i in range(t):
    lt=[]
    rt=deque()
    key=input()
    for x in key:
        if x.isalnum():
            lt.append(x)
        else:
            if x=='<' and len(lt)>0:
                rt.appendleft(lt.pop())
            elif x=='>' and len(rt)>0:
                lt.append(rt.popleft())
            elif x=='-' and len(lt)>0:
                lt.pop()
    rt=list(rt)
    res=lt+rt
    for x in res:
        print(x, end='')
    print()
