n, m=map(int, input().split())
S=dict()
cnt=0
for i in range(n):
    idx=input()
    S[idx]=True

for i in range(m):
    tmp=input()
    if tmp in S:
        cnt+=1
print(cnt)