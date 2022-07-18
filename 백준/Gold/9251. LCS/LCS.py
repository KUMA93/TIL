import sys
input=sys.stdin.readline

S1=list(input().strip())
S2=list(input().strip())
len1, len2=len(S1), len(S2)
dp=[0]*len2

for i in range(len1):
    cnt=0
    for j in range(len2):
        if cnt<dp[j]:
            cnt=dp[j]
        elif S1[i]==S2[j]:
            dp[j]=cnt+1
print(max(dp))