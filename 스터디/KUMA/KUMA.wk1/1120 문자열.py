import sys
sys.stdin=open("input.txt", "rt")

a, b=map(str, input().split())
minC=2147000000
for i in range(len(b)-len(a)+1): #두 문자열의 길이 차이만큼 전수 조사
    cnt=0
    for j in range(len(a)):
        if a[j]!=b[j+i]:
            cnt+=1
    minC=min(minC, cnt)
print(minC)


# 처음 했던 방식, 하다가 알파벳 26개를 전부 앞뒤로 붙여 보는건 비효율적이고 오래걸린다고 생각들어서 위의 코드로 변경함
a, b=map(str, input().split())
a=list(a)
b=list(b)
alpha=list(range(97, 123))
minC=2147000000
def compStr(a, b):
    global minC
    if len(a)==len(b):
        cnt=0
        for i in range(len(a)):
            if a[i]!=b[i]:
                cnt+=1
        minC=min(minC, cnt)
        return
    else:
        if all(a[i] in b for i in range(len(a))):
            minC=0
            return
        for i in range(26):
            a.insert(0, chr(alpha[i]))
            compStr(a, b)
            a.remove(chr(alpha[i]))
        for i in range(26):
            a.append(chr(alpha[i]))
            compStr(a, b)
            a.pop()
compStr(a, b)
print(minC)
