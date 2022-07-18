import sys
input=sys.stdin.readline

S=input().strip()
q=int(input())
alpha=[0]*26
rec=[0]*len(S)
for i in range(len(S)):
    if alpha[ord(S[i])-97]>0:
        alpha[ord(S[i])-97]+=1
    else:
        alpha[ord(S[i])-97]=1
    rec[i]=alpha.copy()

for t in range(q):
    a, i, j=input().split()
    i, j=int(i), int(j)
    if i==0:
        print(rec[j][ord(a)-97])
    else:
        print(rec[j][ord(a)-97]-rec[i-1][ord(a)-97])
