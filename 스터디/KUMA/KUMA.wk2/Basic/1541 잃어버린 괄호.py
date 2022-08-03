import sys
sys.stdin=open("input.txt", "rt")
from collections import deque
input=sys.stdin.readline
stc=deque(input().strip()) #식의 길이는 50이하, 각 수는 5자리까지
#'-'가 등장했을 때 다음 '-'전까지 괄호로 묶는 것이 최소값이 될 것 같다
state=0
state_zero=0
res=[]
while stc:
    now=stc.popleft()
    if now=='-':
        if state==0:
            res.append(now)
            res.append('(')
            state = 1
        elif state==1:
            res.append(')')
            res.append(now)
            res.append('(')
        state_zero=0
    elif now.isdigit():
        if now=='0': # stc에 저장된 숫자들의 타입이 str이기 때문에 0을 판별할때 이렇게 해줘야 됨
            if state_zero==0:
                continue
            else:
                res.append(now)
        else:
            state_zero=1
            res.append(now)
    else: # '+'일 때
        state_zero=0
        res.append(now)
if res[-1]=='+' or res[-1]=='-': # 연산자 다음에 000같이 모조리 입력받지 않는값을 받았을 때 마지막으로 혼자 남은 연산자 제거
    res.pop()
if state==1:
    res.append(')')

res=''.join(res)
print(eval(res))
