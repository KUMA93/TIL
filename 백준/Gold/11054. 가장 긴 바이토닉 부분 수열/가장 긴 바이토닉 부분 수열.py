import sys
input=sys.stdin.readline

n=int(input())
a=list(map(int, input().split()))

dplt=[1]*n
dprt=[1]*n
# 변수 k를 기준으로 둬서 하나의 반복문으로
# dp[k]를 k값에 대한 증감 부분 수열 최대치로 생각, dplt[k]와 dprt[k]의 합으로 구한다.
# 1 5 2 1 4 3 4 5 2 1
# 1 2 5 4 3 4 1 2 5 1
for k in range(n):
    for x in range(k):
        if a[k]>a[x]:
            dplt[k]=max(dplt[k], dplt[x]+1)
for k in range(n-1, -1, -1):
    for x in range(n-1, k, -1):
        if a[k]>a[x]:
            dprt[k]=max(dprt[k], dprt[x]+1)
dp=[]
for i in range(n):
    dp.append(dplt[i]+dprt[i]-1)
print(max(dp))