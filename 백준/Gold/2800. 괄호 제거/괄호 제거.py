import sys
from itertools import combinations
input=sys.stdin.readline

S=list(input().rstrip())
# 쌍으로 짝지어진 괄호를 제거, 2**괄호의 쌍 개수(여는 괄호 or 닫는 괄호 개수) -1(제거를 하나도 하지 않고모두 그대로 있는 경우)
stack=[]
tmp=[]
answer=set()

# tmp에 괄호쌍 인덱스 저장
for i, v in enumerate(S):
    if v=='(':
        stack.append(i)
    elif v==')':
        tmp.append((stack.pop(), i))
# print(tmp)

for i in range(1, len(tmp)+1):
    comb = combinations(tmp, i)
    for j in comb:
        target=list(S)
        for k in j:
            target[k[0]] = ''
            target[k[1]] = ''
        answer.add(''.join(target))

for x in sorted(list(answer)):
    print(x)