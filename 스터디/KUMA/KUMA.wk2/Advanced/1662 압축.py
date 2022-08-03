import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

S=input().strip()
res=[]
'''
33(562(71(9)))
33(562(79))
33(567979)
3567979567979567979
스택에서 ')'가 등장하면 '('가 등장할때까지의 문자열을 '(' 다음 숫자만큼 반복해서 넣는다
) ) ) 9 ( 1 7 
15(22)13(92(1111)42(222))123(1)45
1222222222213(92(1111)42(222))123(1)45
1222222222219111111114222222911111111422222291111111142222221211145
1 5 ( 1 1
1 10
1 10 1 3
'''
# 직접 압축을 해제하고 결과 문자열을 구한다음 길이를 구하는 방식은 메모리 초과가 발생한다..
# for i in range(len(S)):
#     if S[i].isdigit():
#         res.append(S[i])
#     elif S[i]=='(':
#         res.append(S[i])
#     else:
#         tmp=''
#         while res:
#             now=res.pop()
#             if now=='(':
#                 break
#             tmp+=now
#         tmp=int(res.pop())*tmp
#         res.append(tmp)
# while res:
#     print(res.pop(), end='')
# print()
# print(len(''.join(res)))

# 위의 방식에서 문자열의 길이만 계산하는식으로 변경
for i in range(len(S)):
    if i<len(S)-1 and S[i+1]=='(':
        res.append(int(S[i]))
    elif S[i]=='(':
        res.append(S[i])
    elif S[i]==')':
        cnt=0
        while res:
            now=res.pop()
            if now=='(':
                break
            cnt+=now
        print(cnt)
        res.append(cnt*int(res.pop()))
    #S[i], S[i+1]이 숫자인 경우, i=len(S)-1일 때 S[i]가 숫자인 경우
    elif i<len(S)-1 and S[i].isdigit() and S[i+1].isdigit():
        res.append(1)
    else:
        res.append(1)
print(sum(res))