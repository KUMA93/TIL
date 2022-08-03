import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

stc=list(input().strip()) #소문자, 숫자, 공백, 특수문자(<,>)
# 코드 자체는 금방 작성했는데 문자열 S 두 번째 입력조건에 위배된 입력이 있는지 입력을 받아올때 strip()을 해주니 바로 정답이 됐다..ㅅㅂ
# 공백이나 괄호가 등장하면 스택에서 하나씩 pop시켜야되는 구조인것 같음
# 괄호 안의 문자열은 정순으로 출력해야한다. 즉, 스택에 넣지않고 바로 출력
# 위의 조건들에 의해 괄호안의 공백은 그냥 공백으로 출력
stack=[]
res=''
state=0
for x in stc:
    if x=='<':
        while stack:
            res+=stack.pop()
        res+=x
        state=1
        #이후로 '>'가 뜨기전까지(state가 0일때까지) res에 append
    elif x=='>':
        res+=x
        state=0
    # 공백일 때보다 알파벳,숫자일때를 조건문 순서로 앞에 넣었었는데 alnum에 공백도 속하는지 답이 다르게 나온다. 이순서가 맞는듯하다
    elif x==' ':
        if state==1:
            res+=x
        elif state==0:
            while stack:
                res+=stack.pop()
            res+=x
    elif x.isalnum:
        if state==1:
            res+=x
        elif state==0:
            stack.append(x)
while stack:
    res+=stack.pop()

print(res)