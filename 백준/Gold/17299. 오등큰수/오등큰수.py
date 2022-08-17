import sys
input=sys.stdin.readline

n=int(input())
A=list(map(int, input().split()))
cnt_A=[]
NGF=[-1]*n
cnt={}
stack=[]

for x in A:
    try:
        cnt[x]+=1
    except:
        cnt[x]=1
for i in range(n):
    cnt_A.append(cnt[A[i]])

for i in range(n):
    while stack and cnt_A[stack[-1]]<cnt_A[i]:
        NGF[stack.pop()]=A[i]
    stack.append(i)
print(*NGF)