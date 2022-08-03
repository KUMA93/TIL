import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

t=int(input())
# 1001 01 1001001 10011 10001 ... 경우의 수가 많다 변수로 100, 1, 01을 저장하고 풀어야할듯
# C는 A, B 사이에 낄수 없다
# 그리디 처럼 문자열 앞에서부터 읽으면서 완성되는 족족 A,B,C로 치환하는 방법을 사용하면 예외가 안생기나? -> B때문에 불가능할거같다
# ACCCA ABBBA AAACCAB CCCBBBAAB
# 100*1*   /   01
# deque 사용해서 하는건 고려 사항이 너무 복잡해서 포기
# 100001 / 1 / 101
# 100을 기준으로 0*1*을 제거, 그 외 01을 제거, 이후 문자열이 남는다면 NO
# 1. 100등장
# 1.1. 0추가
# 1.2. 1등장
# 1.2.1. 1추가
# 2. 01 등장

for i in range(t):
    S=input().rstrip()
    res=True

    while S:
        if S.startswith('100'): # 문자열이 100으로 시작하면
            S=S[3:] # 100 제거
            while S and S.startswith('0'): # 이후 0 추가 등장
                S=S[1:] # 0 추가로 제거
            if len(S)==0: # 0만 등장하다 문자열이 끝났으니 NO
                res=False
                break
            S=S[1:] # 1이 등장, 제거
            while S and S.startswith('1'): # 이후 1 추가 등장
                if len(S)>=3 and S[1]=='0' and S[2]=='0': # '100'의 패턴인 경우에 삭제하지 않음
                    break
                else: # 아닌 경우 추가되는 1 제거
                    S=S[1:]
        elif S.startswith('01'):
            S=S[2:] # 01 패턴 등장시 제거
        else:
            res=False
            break
    if res:
        print("YES")
    else:
        print("NO")