import sys
import copy
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

def optrGene(st, n): # 공백 아스키코드값 32 / + 아스키코드값 43 / - 아스키코드값 45
    if len(st)==n:
        optr.append(copy.deepcopy(st))
        return
    st.append(' ')
    optrGene(st, n)
    st.pop()

    st.append('+')
    optrGene(st, n)
    st.pop()

    st.append('-')
    optrGene(st, n)
    st.pop()

for _ in range(int(input())):
    n=int(input())
    S=''
    case=[]
    optr=[]
    optrGene([], n-1)
    for i in range(1, 2*n):
        if i%2==0:
            S+=' '
        else:
            tmp=i//2+1
            S+=str(tmp)

    for i in range(len(optr)):
        idx=0
        for j in range(len(S)):
            if S[j].isdigit():
                case.append(S[j])
            else:
                case.append(optr[i][idx])
                idx+=1
        res=''.join(case)
        if eval(res.replace(' ', '')) ==0:
            print(res)
        case=[]
    print()